package al.polis.appserver.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
public class CourseDto {
    private Long id;
    private String code;
    private String title;
    private String description;
    private Integer year;
}
