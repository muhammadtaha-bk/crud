package pnc.appiskey.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pnc.appiskey.crud.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String name);
}
