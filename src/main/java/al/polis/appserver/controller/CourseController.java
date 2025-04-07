package al.polis.appserver.controller;

import al.polis.appserver.communication.RespSingleDto;
import al.polis.appserver.dto.CourseDto;
import al.polis.appserver.dto.LongIdDto;
import al.polis.appserver.dto.SimpleStringFilterDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CourseController {
    @PostMapping("/upsertCourse")
    @ResponseBody
    public RespSingleDto<CourseDto> upsertCourse(@RequestBody CourseDto Course) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/filterCourses")
    @ResponseBody
    public RespSingleDto<List<CourseDto>> filterCourses(@RequestBody SimpleStringFilterDto filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public RespSingleDto<Void> deleteCourse(@RequestBody LongIdDto CourseId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping("/upsertCourse")
    @ResponseBody
    public RespSingleDto<CourseDto> getCourse(@RequestBody LongIdDto CourseId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
