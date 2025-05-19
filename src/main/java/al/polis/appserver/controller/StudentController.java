package al.polis.appserver.controller;

import al.polis.appserver.communication.ErrorContext;
import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.communication.RespSliceDto;
import al.polis.appserver.dto.*;
import al.polis.appserver.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/upsertStudent")
    @ResponseBody
    public RespSingleDto<StudentDto> upsertStudent(@RequestBody StudentDto student) {
        StudentDto res = null;
        try {
            res = studentService.upsertStudent(student);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/filterStudents")
    @ResponseBody
    public RespSliceDto<StudentDto> filterStudents(@RequestBody SimpleStringFilterDto filter) {
        Slice<StudentDto> res = null;
        try {
            res = studentService.filterStudents(filter);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSliceDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/deleteStudent")
    @ResponseBody
    public RespSingleDto<Void> deleteStudent(@RequestBody LongIdDto studentId) {
        try {
            studentService.deleteStudent(studentId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/associateStudentToCourse")
    @ResponseBody
    public RespSingleDto<Void> associateStudentToCourse(@RequestBody CourseStudentAssocDto assoc) {
        try {
            studentService.associateStudentToCourse(assoc);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/removeStudentFromCourse")
    @ResponseBody
    public RespSingleDto<Void> removeStudentFromCourse(@RequestBody CourseStudentAssocDto assoc) {
        try {
            studentService.removeStudentFromCourse(assoc);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/getStudent")
    @ResponseBody
    public RespSingleDto<StudentDto> getStudent(@RequestBody LongIdDto studentId) {
        StudentDto res = null;
        try {
            res = studentService.getStudent(studentId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

}
