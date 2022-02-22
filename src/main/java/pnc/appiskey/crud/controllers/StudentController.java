package pnc.appiskey.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pnc.appiskey.crud.models.Student;
import pnc.appiskey.crud.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public String registerStudent(@RequestBody Student student) {
        return service.register(student);
    }

    @GetMapping
    public ResponseEntity getStudentByIdOrName(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name) {
        if(id != null){
            return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
        } else if(name != null){
            return ResponseEntity.status(HttpStatus.OK).body(service.getByName(name));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        }
    }

    @PutMapping("/{id}")
    public String updateStudentName(@PathVariable Long id, @RequestBody Student student) {
        return service.updateName(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }
}
