package pnc.appiskey.crud.services;

import org.springframework.http.ResponseEntity;
import pnc.appiskey.crud.models.Course;

public interface CourseService {
    ResponseEntity getById(Long id);

    ResponseEntity getByName(String name);

    ResponseEntity getAll();

    String register(Course course);

    String delete(Long id);

    String enrollStudent(Long courseId, Long studentId);

    String assignTeacher(Long courseId, Long teacherId);
}
