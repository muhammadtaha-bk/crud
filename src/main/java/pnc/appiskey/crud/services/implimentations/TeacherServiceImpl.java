package pnc.appiskey.crud.services.implimentations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pnc.appiskey.crud.models.Student;
import pnc.appiskey.crud.models.Teacher;
import pnc.appiskey.crud.repositories.StudentRepository;
import pnc.appiskey.crud.repositories.TeacherRepository;
import pnc.appiskey.crud.services.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;
    private final StudentRepository studentRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository, StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
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
    public ResponseEntity get(Long id) {
        if (repository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Teacher not found \u274c");
    }

    @Override
    public String updateName(Long id, Teacher teacher) {
        if (repository.findById(id).isPresent()) {
            Teacher t = repository.findById(id).get();
            t.setName(teacher.getName());
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

//    @Override
//    public String assignTeacherToStudent(Long studentId, Long teacherId) {
//        if (repository.findById(teacherId).isPresent()
//                && studentRepository.findById(studentId).isPresent()) {
//            Student student = studentRepository.findById(studentId).get();
//            Teacher teacher = repository.findById(teacherId).get();
//             teacher.assignTeacher(student);
//            repository.save(teacher);
//            return "Teacher assigned \u2713";
//        }
//        return "Unable to assign teacher to student \u274c";
//    }
}
