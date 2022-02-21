package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Teacher;

public interface TeacherService {
    String register(Teacher teacher);

    ResponseEntity getAll();

    ResponseEntity get(Long id);

    String updateName(Long id, Teacher teacher);

    String deleteTeacher(Long id);

    String assignTeacherToStudent(Long studentId, Long teacherId);
}
