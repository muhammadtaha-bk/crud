package pnc.appiskey.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Student> enrolledStudents;
    @OneToOne
    private Teacher taughtBy;

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void assignTeacher(Teacher teacher) {
        this.taughtBy = teacher;
    }

    public Course() {
    }

    public Course(Long id, String name, Set<Student> enrolledStudents, Teacher taughtBy) {
        this.id = id;
        this.name = name;
        this.enrolledStudents = enrolledStudents;
        this.taughtBy = taughtBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(Set<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public Teacher getTaughtBy() {
        return taughtBy;
    }

    public void setTaughtBy(Teacher taughtBy) {
        this.taughtBy = taughtBy;
    }

}
