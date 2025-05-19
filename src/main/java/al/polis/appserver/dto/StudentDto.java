package al.polis.appserver.dto;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String serialNumber;
    private CourseDto course;
}
