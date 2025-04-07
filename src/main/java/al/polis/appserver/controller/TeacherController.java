package al.polis.appserver.controller;

import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.dto.TeacherDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class TeacherController {
    @PostMapping("/upsertTeacher")
    @ResponseBody
    public RespSingleDto<TeacherDto> upsertTeacher(@RequestBody TeacherDto Teacher) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/filterTeachers")
    @ResponseBody
    public RespSingleDto<List<TeacherDto>> filterTeachers(@RequestBody SimpleStringFilterDto filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/deleteTeacher")
    @ResponseBody
    public RespSingleDto<Void> deleteTeacher(@RequestBody LongIdDto TeacherId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/associateToCourse")
    @ResponseBody
    public RespSingleDto<Void> associateToCourse(@RequestBody CourseTeacherAssocDto assoc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/removeFromCourse")
    @ResponseBody
    public RespSingleDto<Void> removeFromCourse(@RequestBody CourseTeacherAssocDto assoc) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/upsertTeacher")
    @ResponseBody
    public RespSingleDto<TeacherDto> getTeacher(@RequestBody LongIdDto TeacherId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
