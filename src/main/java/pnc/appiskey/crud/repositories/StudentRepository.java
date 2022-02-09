package pnc.appiskey.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pnc.appiskey.crud.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
