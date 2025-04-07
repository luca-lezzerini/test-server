package al.polis.appserver.repo;

import al.polis.appserver.model.Course;
import al.polis.appserver.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
