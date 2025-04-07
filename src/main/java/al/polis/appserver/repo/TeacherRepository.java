package al.polis.appserver.repo;

import al.polis.appserver.model.Student;
import al.polis.appserver.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
