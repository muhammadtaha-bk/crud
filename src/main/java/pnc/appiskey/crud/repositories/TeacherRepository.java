package pnc.appiskey.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pnc.appiskey.crud.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
