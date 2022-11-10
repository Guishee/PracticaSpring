package demoSpringJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;


    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<CourseMaterial> courseMaterial;

    public Course(long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Course() {
    }

    public List<CourseMaterial> getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(List<CourseMaterial> courseMaterial) {
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
