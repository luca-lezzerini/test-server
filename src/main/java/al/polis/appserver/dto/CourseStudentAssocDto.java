package al.polis.appserver.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseStudentAssocDto {

    private Long idStudent;
    private Long idCourse;
}
