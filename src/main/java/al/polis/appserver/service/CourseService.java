package al.polis.appserver.service;

import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CourseService {
    CourseDto upsertCourse(CourseDto course);

    Slice<CourseDto> filterCourses(SimpleStringFilterDto filter);

    void deleteCourse(LongIdDto courseId);

    CourseDto getCourse(LongIdDto courseId);

    void associateTeacherToCourse(CourseTeacherAssocDto assoc);

    void removeTeacherFromCourse(CourseTeacherAssocDto assoc);


}
