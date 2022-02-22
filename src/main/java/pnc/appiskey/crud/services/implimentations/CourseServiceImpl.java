package pnc.appiskey.crud.services.implimentations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pnc.appiskey.crud.models.Course;
import pnc.appiskey.crud.models.Student;
import pnc.appiskey.crud.models.Teacher;
import pnc.appiskey.crud.repositories.CourseRepository;
import pnc.appiskey.crud.repositories.StudentRepository;
import pnc.appiskey.crud.repositories.TeacherRepository;
import pnc.appiskey.crud.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository repository,
                             StudentRepository studentRepository,
                             TeacherRepository teacherRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public ResponseEntity getById(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id));
    }

    @Override
    public ResponseEntity getByName(String name) {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findByName(name));
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String register(Course course) {
        repository.save(course);
        return "Course registered \u2713";
    }

    @Override
    public String delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.delete(repository.findById(id).get());
            return "Course deleted \u2713";
        }
        return "Course not found \u274c";
    }

    @Override
    public String enrollStudent(Long courseId, Long studentId) {
        if (repository.findById(courseId).isPresent() && studentRepository.findById(studentId).isPresent()) {
            Course course = repository.findById(courseId).get();
            Student student = studentRepository.findById(studentId).get();

            course.enrollStudent(student);
            repository.save(course);
            return "Student enrolled \u2713";
        }
        return "Unable to enroll student \u274c";
    }

    @Override
    public String assignTeacher(Long courseId, Long teacherId) {
        if (repository.findById(courseId).isPresent() && teacherRepository.findById(teacherId).isPresent()) {
            Course course = repository.findById(courseId).get();
            Teacher teacher = teacherRepository.findById(teacherId).get();

            course.assignTeacher(teacher);
            repository.save(course);

            return "Teacher assigned \u2713";
        }
        return "Unable to assign teacher \u274c";
    }

}
