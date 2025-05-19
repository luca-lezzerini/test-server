package al.polis.appserver.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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

    @ManyToOne
    private Teacher teacher;

    @OneToMany
    private List<Student> students;
}
