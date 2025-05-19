package al.polis.appserver.dto;

import al.polis.appserver.model.Student;
import al.polis.appserver.model.Teacher;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
public class CourseDto {
    private Long id;
    private String code;
    private String title;
    private String description;
    private Integer year;
    private Teacher teacher;
    private List<StudentDto> students;
}
