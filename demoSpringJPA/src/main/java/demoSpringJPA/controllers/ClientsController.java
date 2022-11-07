package demoSpringJPA.controllers;

import demoSpringJPA.entities.Course;
import demoSpringJPA.repositoris.CourseMaterialRepository;
import demoSpringJPA.repositoris.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demoSpringJPA.entities.Student;
import demoSpringJPA.repositoris.ClientsRepository;

import java.util.List;

@RestController
@RequestMapping("api")
public class ClientsController {
	
	@Autowired
	ClientsRepository clientRep;
	@Autowired
	CourseRepository courseRep;
	@Autowired
	CourseMaterialRepository couseMatRep;
	
	@GetMapping("student/{id}")//busca estudiantes por id
	public Student getStudent(@PathVariable long id) {
		Student student = clientRep.findById(id).get(); //clientRep es el rep de Student

		return student;
	}
	@GetMapping("course/{id}")//busca cursos por id
	public Course getCourse(@PathVariable long id){
		Course curso= courseRep.findById(id).get();
		return curso;
	}
	@GetMapping("course/all")
	public List<Course> getCourses(){
		return (List<Course>) courseRep.findAll();
	}


}