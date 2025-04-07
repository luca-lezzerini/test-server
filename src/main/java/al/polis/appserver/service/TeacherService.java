package al.polis.appserver.service;

import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.TeacherDto;

import java.util.List;

public interface TeacherService {
    TeacherDto upsertTeacher(TeacherDto teacher);

    List<TeacherDto> filterTeachers(SimpleStringFilterDto filter);

    void deleteTeacher(LongIdDto teacherId);

    void associateToCourse(CourseTeacherAssocDto assoc);

    void removeFromCourse(CourseTeacherAssocDto assoc);

    TeacherDto getTeacher(LongIdDto teacherId);

}
