package demoSpringJPA.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;




    @ManyToOne(optional = true)
    @JoinColumn(name = "COURSE_ID", nullable = true)
    @JsonIgnore
    private Course course;



    private String url;

    public CourseMaterial() {
    }

    public CourseMaterial(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public void courseSetNull(){
        course=null;
    }

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
