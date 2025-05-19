package al.polis.appserver.service;

import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.TeacherDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface TeacherService {
    TeacherDto upsertTeacher(TeacherDto teacher);

    Slice<TeacherDto> filterTeachers(SimpleStringFilterDto filter);

    void deleteTeacher(LongIdDto teacherId);


    TeacherDto getTeacher(LongIdDto teacherId);

}
