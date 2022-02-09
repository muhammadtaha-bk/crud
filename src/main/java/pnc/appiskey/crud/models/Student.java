package pnc.appiskey.crud.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "studentSet")
    private Set<Teacher> teacherSet;

    public void assignTeacher(Teacher teacher) {
        teacherSet.add(teacher);
    }

    public Student() {
        super();
    }

    public Student(Long id, String name, Set<Teacher> teacherSet) {
        this.id = id;
        this.name = name;
        this.teacherSet = teacherSet;
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

    public Set<Teacher> getteacherSet() {
        return teacherSet;
    }

    public void setteacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacherSet=" + teacherSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (!id.equals(student.id)) return false;
        if (!name.equals(student.name)) return false;
        return teacherSet != null ? teacherSet.equals(student.teacherSet) : student.teacherSet == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (teacherSet != null ? teacherSet.hashCode() : 0);
        return result;
    }
}
