package demoSpringJPA.controllers;

import demoSpringJPA.entities.Course;
import demoSpringJPA.entities.CourseMaterial;
import demoSpringJPA.repositoris.CourseMaterialRepository;
import demoSpringJPA.repositoris.CourseRepository;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	@GetMapping("course/{id}")//busca por id
	public Course getCourse(@PathVariable long id){
		Course cursos= courseRep.findById(id).get();
		System.out.println("EAGER o LAZY");
		return cursos;
	}
	@GetMapping("course/all")
	public List<Course> getCourses(){
		return (List<Course>) courseRep.findAll();
	}

	@GetMapping("course/material")
	public List<CourseMaterial> getCourseMat(){
		return (List<CourseMaterial>) couseMatRep.findAll();
	}
	@GetMapping("course/material/{id}")
	public CourseMaterial getCourseMat(@PathVariable long id){
		CourseMaterial cm= couseMatRep.findById(id).get();
		return cm;
	}
	@GetMapping("delete/course/{id}")//Con esto me ha ayudado el 8a por si algunas lineas de codigo se parecen
	public void delCourse(@PathVariable long id){//he tomado referencia en su codigo
		if(courseRep.existsById(id)){
			Course del=courseRep.findById(id).get();

			for(int j=0; j<del.getCourseMaterial().size();j++){
				del.getCourseMaterial().get(j).courseSetNull();
			}

			courseRep.deleteById(id);
			System.out.println("Se ha eliminado el curso");
		}


	}

}
