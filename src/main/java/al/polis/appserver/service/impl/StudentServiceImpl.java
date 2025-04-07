package al.polis.appserver.service.impl;

import al.polis.appserver.dto.CourseStudentAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.StudentDto;
import al.polis.appserver.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public StudentDto upsertStudent(StudentDto student) {
        return null;
    }

    @Override
    public List<StudentDto> filterStudents(SimpleStringFilterDto filter) {
        return List.of();
    }

    @Override
    public void deleteStudent(LongIdDto studentId) {

    }

    @Override
    public void associateToCourse(CourseStudentAssocDto assoc) {

    }

    @Override
    public void removeFromCourse(CourseStudentAssocDto assoc) {

    }

    @Override
    public StudentDto getStudent(LongIdDto studentId) {
        return null;
    }
}
