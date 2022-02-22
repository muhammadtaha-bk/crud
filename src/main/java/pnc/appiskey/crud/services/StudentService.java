package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Student;

public interface StudentService {
    String register(Student student);

    ResponseEntity getById(Long id);

    ResponseEntity getAll();

    String updateDetails(Long id, Student student);

    String deleteStudent(Long id);

    ResponseEntity getByName(String name);

    ResponseEntity getByEmail(String email);
}
