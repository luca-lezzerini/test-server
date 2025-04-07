package al.polis.appserver.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CourseTeacherAssocDto {

    private Long idTeacher;
    private Long idCourse;
}
