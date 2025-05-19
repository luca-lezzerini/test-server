package al.polis.appserver.service.impl;

import al.polis.appserver.communication.ErrorContext;
import al.polis.appserver.communication.ServerErrorEnum;
import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.exception.TestServerRuntimeException;
import al.polis.appserver.mapper.CourseMapper;
import al.polis.appserver.model.Course;
import al.polis.appserver.model.Teacher;
import al.polis.appserver.repo.CourseRepository;
import al.polis.appserver.repo.TeacherRepository;
import al.polis.appserver.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;

    @Transactional
    @Override
    public CourseDto upsertCourse(CourseDto course) {
        if (course == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_MISSING);
            throw new TestServerRuntimeException("Course is null");
        }
        Course entity = courseMapper.toEntity(course);
        Course res = courseRepository.save(entity);
        CourseDto dto = courseMapper.toDto(res);
        return dto;
    }

    @Override
    public Slice<CourseDto> filterCourses(SimpleStringFilterDto filter) {
        if (filter == null || filter.getPagination() == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_MISSING);
            throw new TestServerRuntimeException("Filter is null or has no pagination info.");
        }
        String criterion = "";
        Slice<Course> courses = null;
        if (filter.getFilter() == null || filter.getFilter().isEmpty()) {
            courses = courseRepository.findAll(PageRequest.of(0, 20));

        } else {
            criterion = filter.getFilter();
            courses = courseRepository
                    .findByCodeContainsOrTitleContainsOrDescriptionContains(
                            criterion,
                            criterion,
                            criterion,
                            PageRequest.of(
                                    filter.getPagination().getPageNumber(),
                                    filter.getPagination().getPageSize()));
        }

        List<CourseDto> dtos = courses.stream().map(courseMapper::toDto).toList();
        Slice<CourseDto> result = new SliceImpl<>(dtos, courses.getPageable(), courses.hasNext());
        return result;
    }

    @Override
    public void deleteCourse(LongIdDto courseId) {
        if (courseId == null || courseId.getId() == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id is null " + courseId);
        }

        Course course = courseRepository.findById(courseId.getId()).orElse(null);
        if (course == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id not found " + courseId);
        }

        if (course.getTeacher() != null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.DELETE_COURSE_NOT_ALLOWED);
            throw new TestServerRuntimeException("Course has teacher and cannot be deleted.");
        }

        if (course.getStudents() == null || course.getStudents().isEmpty()) {
            ErrorContext.addStatusMessage(ServerErrorEnum.DELETE_COURSE_NOT_ALLOWED);
            throw new TestServerRuntimeException("Course has students and cannot be deleted.");
        }

        courseRepository.delete(course);
    }

    @Override
    public CourseDto getCourse(LongIdDto courseId) {
        if (courseId == null || courseId.getId() == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_MISSING);
            throw new TestServerRuntimeException("Course id is null " + courseId);
        }

        Course course = courseRepository.findById(courseId.getId()).orElse(null);
        if (course == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id not found " + courseId);
        }

        CourseDto res = courseMapper.toDto(course);
        return res;
    }

    @Override
    public void associateTeacherToCourse(CourseTeacherAssocDto assoc) {
        Long courseId = assoc.getIdCourse();
        Long teacherId = assoc.getIdTeacher();

        if (courseId == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_MISSING);
            throw new TestServerRuntimeException("Course id is null " + courseId);
        }

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id not found " + courseId);
        }

        if (teacherId == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.TEACHER_MISSING);
            throw new TestServerRuntimeException("Teacher id is null " + courseId);
        }

        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.TEACHER_NOT_FOUND);
            throw new TestServerRuntimeException("Teacher id not found " + courseId);
        }

        course.setTeacher(teacher);
        courseRepository.save(course);
        List<Course> list = teacher.getCourses();
        if (list != null) {
            list.removeIf(c -> c.getTeacher() != null && c.getTeacher().getId().equals(teacherId));
            list.add(course);
        } else {
            list = new ArrayList<>();
            list.add(course);
            teacher.setCourses(list);
        }
        teacherRepository.save(teacher);
    }

    @Override
    public void removeTeacherFromCourse(CourseTeacherAssocDto assoc) {
        Long courseId = assoc.getIdCourse();
        Long teacherId = assoc.getIdTeacher();

        if (courseId == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id is null " + courseId);
        }

        Course course = courseRepository.findById(courseId).orElse(null);
        if (course == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.COURSE_NOT_FOUND);
            throw new TestServerRuntimeException("Course id not found " + courseId);
        }

        if (teacherId == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.TEACHER_MISSING);
            throw new TestServerRuntimeException("Teacher id is null " + courseId);
        }

        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        if (teacher == null) {
            ErrorContext.addStatusMessage(ServerErrorEnum.TEACHER_NOT_FOUND);
            throw new TestServerRuntimeException("Teacher id not found " + courseId);
        }

        course.setTeacher(null);
        courseRepository.save(course);
        List<Course> list = teacher.getCourses();
        if (list != null) {
            list.removeIf(c -> c.getTeacher() != null && c.getTeacher().getId().equals(teacherId));
        } else {
            teacher.setCourses(new ArrayList<>());
        }
        teacherRepository.save(teacher);
    }
}
