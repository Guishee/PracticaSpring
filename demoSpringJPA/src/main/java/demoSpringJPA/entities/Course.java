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


    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER, orphanRemoval = false)
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

    public void addCourseMat(CourseMaterial cm){
        courseMaterial.add(cm);
        cm.setCourse(this);
    }
    public void removeCourseMat(CourseMaterial cm){
        courseMaterial.remove(cm);
        cm.setCourse(null);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
