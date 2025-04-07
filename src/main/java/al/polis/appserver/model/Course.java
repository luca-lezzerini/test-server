package al.polis.appserver.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue
    private Long id;
    private String code;
    private String title;
    private String description;
    private Integer year;
}
