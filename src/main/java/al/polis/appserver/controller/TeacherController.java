package al.polis.appserver.controller;

import al.polis.appserver.communication.ErrorContext;
import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.communication.RespSliceDto;
import al.polis.appserver.dto.*;
import al.polis.appserver.mapper.TeacherMapper;
import al.polis.appserver.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @PostMapping("/upsertTeacher")
    @ResponseBody
    public RespSingleDto<TeacherDto> upsertTeacher(@RequestBody TeacherDto teacher) {
        TeacherDto res = null;
        try {
            res = teacherService.upsertTeacher(teacher);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/filterTeachers")
    @ResponseBody
    public RespSliceDto<TeacherDto> filterTeachers(@RequestBody SimpleStringFilterDto filter) {
        Slice<TeacherDto> res = null;
        try {
            res = teacherService.filterTeachers(filter);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSliceDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/deleteTeacher")
    @ResponseBody
    public RespSingleDto<Void> deleteTeacher(@RequestBody LongIdDto teacherId) {
        try {
            teacherService.deleteTeacher(teacherId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/getTeacher")
    @ResponseBody
    public RespSingleDto<TeacherDto> getTeacher(@RequestBody LongIdDto teacherId) {
        TeacherDto res = null;
        try {
            res = teacherService.getTeacher(teacherId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

}
