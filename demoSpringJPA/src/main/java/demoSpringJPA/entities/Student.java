package demoSpringJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Student { //Plain Old Java Object (POJO)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	private String cognoms;
	private LocalDate Birth_Date;
	private boolean newsletter;

	@ManyToMany
			@JoinTable(
					name="course_like",
					joinColumns = @JoinColumn(name="student_id"),
					inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Course> likedCourses;

	public Set<Course> getLePertenecen() {
		return likedCourses;
	}

	public void setLePertenecen(Set<Course> lePertenecen) {
		this.likedCourses = lePertenecen;
	}

	public Student() { //constructor sense arguments
	}

	public Student(String nom, String cognoms, LocalDate Birth_Date, boolean wantsNewsletterletter) {
		super();
		this.nom = nom;
		this.cognoms = cognoms;
		this.Birth_Date = Birth_Date;
		this.newsletter =wantsNewsletterletter;
	}


	public boolean isNewsletter() {
		return newsletter;
	}

	public void setNewsletter(boolean wantsNewsletter) {
		this.newsletter = wantsNewsletter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognoms() {
		return cognoms;
	}

	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}

	public LocalDate getBirth_Date() {
		return Birth_Date;
	}

	public void setBirth_Date(LocalDate dataAlta) {
		this.Birth_Date = dataAlta;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", nom='" + nom + '\'' +
				", cognoms='" + cognoms + '\'' +
				", birthDate=" + Birth_Date +
				", wantsNewsletter=" + newsletter +
				'}';
	}
}
