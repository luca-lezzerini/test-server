package al.polis.appserver.controller;

import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.dto.CourseStudentAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.StudentDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {
    @PostMapping("/upsertStudent")
    @ResponseBody
    public RespSingleDto<StudentDto> upsertStudent(@RequestBody StudentDto student) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/filterStudents")
    @ResponseBody
    public RespSingleDto<List<StudentDto>> filterStudents(@RequestBody SimpleStringFilterDto filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/deleteStudent")
    @ResponseBody
    public RespSingleDto<Void> deleteStudent(@RequestBody LongIdDto studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/associateToCourse")
    @ResponseBody
    public RespSingleDto<Void> associateToCourse(@RequestBody CourseStudentAssocDto assoc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/removeFromCourse")
    @ResponseBody
    public RespSingleDto<Void> removeFromCourse(@RequestBody CourseStudentAssocDto assoc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @PostMapping("/upsertStudent")
    @ResponseBody
    public RespSingleDto<StudentDto> getStudent(@RequestBody LongIdDto studentId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
