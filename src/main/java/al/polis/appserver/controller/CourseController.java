package al.polis.appserver.controller;

import al.polis.appserver.communication.ErrorContext;
import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.communication.RespSliceDto;
import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.CourseTeacherAssocDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import al.polis.appserver.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@Slf4j
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping("/upsertCourse")
    @ResponseBody
    public RespSingleDto<CourseDto> upsertCourse(@RequestBody CourseDto course) {
        CourseDto res = null;
        try {
            res = courseService.upsertCourse(course);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/filterCourses")
    @ResponseBody
    public RespSliceDto<CourseDto> filterCourses(@RequestBody SimpleStringFilterDto filter) {
        Slice<CourseDto> res = null;
        try {
            res = courseService.filterCourses(filter);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSliceDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public RespSingleDto<Void> deleteCourse(@RequestBody LongIdDto courseId) {
        try {
            courseService.deleteCourse(courseId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/getCourse")
    @ResponseBody
    public RespSingleDto<CourseDto> getCourse(@RequestBody LongIdDto courseId) {
        CourseDto res = null;
        try {
            res = courseService.getCourse(courseId);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(res, ErrorContext.readAndClean());
    }

    @PostMapping("/associateTeacherToCourse")
    @ResponseBody
    public RespSingleDto<Void> associateTeacherToCourse(@RequestBody CourseTeacherAssocDto assoc) {
        try {
            courseService.associateTeacherToCourse(assoc);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

    @PostMapping("/removeTeacherFromCourse")
    @ResponseBody
    public RespSingleDto<Void> removeTeacherFromCourse(@RequestBody CourseTeacherAssocDto assoc) {
        try {
            courseService.removeTeacherFromCourse(assoc);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
        return new RespSingleDto<>(null, ErrorContext.readAndClean());
    }

}
