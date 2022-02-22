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
    public ResponseEntity getTeacherByIdOrName(@RequestParam(required = false) Long id,
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
    public String deleteTeacher(@PathVariable Long id) {
        return service.deleteTeacher(id);
    }

    @PutMapping("/{id}")
    public String updateInfo(@PathVariable Long id, @RequestBody Teacher teacher) {
        return service.updateDetails(id, teacher);
    }
}
