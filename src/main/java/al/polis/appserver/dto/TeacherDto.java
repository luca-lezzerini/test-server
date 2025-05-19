package al.polis.appserver.dto;

import al.polis.appserver.model.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
public class TeacherDto {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String title;
    private List<CourseDto> courses;
}
