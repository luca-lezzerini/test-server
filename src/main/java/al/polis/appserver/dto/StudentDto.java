package al.polis.appserver.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String serialNumber;
}
