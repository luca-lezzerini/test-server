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
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String title;

    @OneToMany
    private List<Course> courses;
}
