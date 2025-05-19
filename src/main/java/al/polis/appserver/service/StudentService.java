package al.polis.appserver.service;

import al.polis.appserver.dto.CourseStudentAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.StudentDto;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface StudentService {
    StudentDto upsertStudent(StudentDto student);

    Slice<StudentDto> filterStudents(SimpleStringFilterDto filter);

    void deleteStudent(LongIdDto studentId);

    void associateStudentToCourse(CourseStudentAssocDto assoc);

    void removeStudentFromCourse(CourseStudentAssocDto assoc);

    StudentDto getStudent(LongIdDto studentId);

}
