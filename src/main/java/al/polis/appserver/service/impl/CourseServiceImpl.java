package al.polis.appserver.service.impl;

import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.service.CourseService;
import lombok.Setter;

import java.util.List;

@Setter
public class CourseServiceImpl implements CourseService {
    @Override
    public CourseDto upsertCourse(CourseDto course) {
        return null;
    }

    @Override
    public List<CourseDto> filterCourses(SimpleStringFilterDto filter) {
        return List.of();
    }

    @Override
    public void deleteCourse(LongIdDto courseId) {

    }

    @Override
    public CourseDto getCourse(LongIdDto courseId) {
        return null;
    }
}
