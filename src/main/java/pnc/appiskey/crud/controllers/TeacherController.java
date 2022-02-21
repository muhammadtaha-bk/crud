package pnc.appiskey.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pnc.appiskey.crud.models.Teacher;
import pnc.appiskey.crud.services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @PostMapping
    public String registerTeacher(@RequestBody Teacher teacher) {
        return service.register(teacher);
    }

    @GetMapping
    public ResponseEntity getTeachers() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getTeacher(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.get(id));
    }

    @PutMapping("/{id}")
    public String updateTeacherName(@PathVariable Long id, @RequestBody Teacher teacher) {
        return service.updateName(id, teacher);
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable Long id){
        return service.deleteTeacher(id);
    }

    @PutMapping("/{teacherId}/student/{studentId}")
    public String assignTeacher(@PathVariable Long studentId, @PathVariable Long teacherId) {
        return service.assignTeacherToStudent(studentId, teacherId);
    }

}
