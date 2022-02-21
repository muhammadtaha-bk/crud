package pnc.appiskey.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pnc.appiskey.crud.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
