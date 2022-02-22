package pnc.appiskey.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pnc.appiskey.crud.models.Course;
import pnc.appiskey.crud.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseService service;

    @Autowired
    public CourseController(CourseService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getCourseByIdOrName(@RequestParam(required = false) Long id,
                                              @RequestParam(required = false) String name) {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
        } else if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getByName(name));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        }
    }

    @PostMapping
    public String registerCourse(@RequestBody Course course) {
        return service.register(course);
    }

    @DeleteMapping("/id")
    public String deleteCourse(@PathVariable Long id) {
        return service.delete(id);
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public String enrollStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        return service.enrollStudent(courseId, studentId);
    }

    @PutMapping("/{courseId}/teacher/{teacherId}")
    public String assignTeacher(@PathVariable Long courseId, @PathVariable Long teacherId) {
        return service.assignTeacher(courseId, teacherId);
    }

}
