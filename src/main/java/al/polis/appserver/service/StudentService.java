package al.polis.appserver.service;

import al.polis.appserver.dto.CourseStudentAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto upsertStudent(StudentDto student);

    List<StudentDto> filterStudents(SimpleStringFilterDto filter);

    void deleteStudent(LongIdDto studentId);

    void associateToCourse(CourseStudentAssocDto assoc);

    void removeFromCourse(CourseStudentAssocDto assoc);

    StudentDto getStudent(LongIdDto studentId);

}
