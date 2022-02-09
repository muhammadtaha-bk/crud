package pnc.appiskey.crud.services.implimentations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pnc.appiskey.crud.models.Student;
import pnc.appiskey.crud.models.Teacher;
import pnc.appiskey.crud.repositories.StudentRepository;
import pnc.appiskey.crud.repositories.TeacherRepository;
import pnc.appiskey.crud.services.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final TeacherRepository teacherRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, TeacherRepository teacherRepo) {
        this.repository = repository;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public String register(Student student) {
        repository.save(student);
        return "Student registered \u2713";
    }

    @Override
    public ResponseEntity get(Long id) {
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
    public String updateName(Long id, Student student) {
        if (repository.findById(id).isPresent()) {
            Student s = repository.findById(id).get();
            s.setName(student.getName());
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
    public String assignTeacherToStudent(Long studentId, Long teacherId) {
        if (repository.findById(studentId).isPresent()
                && teacherRepo.findById(teacherId).isPresent()) {
            Student student = repository.findById(studentId).get();
            Teacher teacher = teacherRepo.findById(teacherId).get();
            student.assignTeacher(teacher);
            repository.save(student);
            return "Teacher assigned \u2713";
        }
        return "Unable to assign teacher to student \u274c";
    }
}