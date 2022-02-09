package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Student;

public interface StudentService {
    ResponseEntity get(Long id);

    ResponseEntity getAll();

    String register(Student student);

    String updateName(Long id, Student student);

    String deleteStudent(Long id);

    String assignTeacherToStudent(Long studentId, Long teacherId);
}
