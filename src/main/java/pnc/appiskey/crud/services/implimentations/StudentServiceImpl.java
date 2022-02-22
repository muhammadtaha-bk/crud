package pnc.appiskey.crud.services.implimentations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pnc.appiskey.crud.models.Student;
import pnc.appiskey.crud.repositories.StudentRepository;
import pnc.appiskey.crud.services.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public String register(Student student) {
        repository.save(student);
        return "Student registered \u2713";
    }

    @Override
    public ResponseEntity getById(Long id) {
        if(repository.findById(id).isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found \u274c");
    }

    @Override
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String updateDetails(Long id, Student student) {
        if (repository.findById(id).isPresent()) {
            Student s = repository.findById(id).get();
            s.setName(student.getName());
            s.setEmail(student.getEmail());
            repository.save(s);
            return "Record updated \u2713";
        }
        return "Student not found \u274c";
    }

    @Override
    public String deleteStudent(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(repository.findById(id).get());
            return "Record deleted \u2713";
        }
        return "Student not found \u274c";
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
