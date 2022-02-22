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
    public ResponseEntity getStudentByIdOrName(@RequestParam(required = false) Long id,
                                               @RequestParam(required = false) String name,
                                               @RequestParam(required = false) String email) {
        if (id != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
        } else if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getByName(name));
        } else if (email != null) {
            return ResponseEntity.status(HttpStatus.OK).body(service.getByEmail(email));
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
        }
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return service.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public String updateInfo(@PathVariable Long id, @RequestBody Student student) {
        return service.updateDetails(id, student);
    }
}
