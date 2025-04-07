package al.polis.appserver.service;

import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;

import java.util.List;

public interface CourseService {
    CourseDto upsertCourse(CourseDto course);

    List<CourseDto> filterCourses(SimpleStringFilterDto filter);

    void deleteCourse(LongIdDto courseId);

    CourseDto getCourse(LongIdDto courseId);

}
