package demoSpringJPA.entities;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    public Course(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Course() {
    }

    public CourseMaterial getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(CourseMaterial courseMaterial) {
        this.courseMaterial = courseMaterial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
