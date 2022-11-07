package demoSpringJPA.repositoris;

import demoSpringJPA.entities.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    public List<Course> findAll();
}
