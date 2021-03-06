package pnc.appiskey.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pnc.appiskey.crud.models.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByName(String name);

    @Query("select s from Student s where s.email = ?1")
    Student findByEmail(String email);
}
