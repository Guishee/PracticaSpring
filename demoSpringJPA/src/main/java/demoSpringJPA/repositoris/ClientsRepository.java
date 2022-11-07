package demoSpringJPA.repositoris;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demoSpringJPA.entities.Student;

public interface ClientsRepository extends CrudRepository<Student, Long>{

	public List<Student> findAll();
}
