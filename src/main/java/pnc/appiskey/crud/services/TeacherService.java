package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Teacher;

public interface TeacherService {
    String register(Teacher teacher);

    ResponseEntity getAll();

//    ResponseEntity get(Long id);

    String updateDetails(Long id, Teacher teacher);

    String deleteTeacher(Long id);

    ResponseEntity getById(Long id);

    ResponseEntity getByName(String name);

    ResponseEntity getByEmail(String email);

//    String assignTeacherToStudent(Long studentId, Long teacherId);
}
