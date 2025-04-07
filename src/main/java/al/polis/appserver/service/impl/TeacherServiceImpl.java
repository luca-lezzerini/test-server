package al.polis.appserver.service.impl;

import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.TeacherDto;
import al.polis.appserver.service.TeacherService;

import java.util.List;

public class TeacherServiceImpl implements TeacherService {
    @Override
    public TeacherDto upsertTeacher(TeacherDto teacher) {
        return null;
    }

    @Override
    public List<TeacherDto> filterTeachers(SimpleStringFilterDto filter) {
        return List.of();
    }

    @Override
    public void deleteTeacher(LongIdDto teacherId) {

    }

    @Override
    public void associateToCourse(CourseTeacherAssocDto assoc) {

    }

    @Override
    public void removeFromCourse(CourseTeacherAssocDto assoc) {

    }

    @Override
    public TeacherDto getTeacher(LongIdDto teacherId) {
        return null;
    }
}
