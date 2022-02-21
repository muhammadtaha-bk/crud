package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Student;

public interface StudentService {
    String register(Student student);

    ResponseEntity get(Long id);

    ResponseEntity getAll();

    String updateName(Long id, Student student);

    String deleteStudent(Long id);

}
