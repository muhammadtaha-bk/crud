package pnc.appiskey.crud.services.implimentations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pnc.appiskey.crud.models.Teacher;
import pnc.appiskey.crud.repositories.TeacherRepository;
import pnc.appiskey.crud.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public String register(Teacher teacher) {
        repository.save(teacher);
        return "Teacher registered \u2713";
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }


    @Override
    public String updateDetails(Long id, Teacher teacher) {
        if (repository.findById(id).isPresent()) {
            Teacher t = repository.findById(id).get();
            t.setName(teacher.getName());
            t.setEmail(teacher.getEmail());
            repository.save(t);
            return "Record updated \u2713";
        }
        return "Teacher not found \u274c";
    }

    @Override
    public String deleteTeacher(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(repository.findById(id).get());
            return "Record deleted \u2713";
        }
        return "Teacher not found \u274c";
    }

    @Override
    public ResponseEntity getById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
    }

    @Override
    public ResponseEntity getByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByName(name));
    }

    @Override
    public ResponseEntity getByEmail(String email) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByEmail(email));
    }
}
