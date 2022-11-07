package demoSpringJPA.repositoris;

import demoSpringJPA.entities.Course;
import demoSpringJPA.entities.CourseMaterial;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseMaterialRepository extends CrudRepository<CourseMaterial, Long> {
    public List<CourseMaterial> findAll();
}
