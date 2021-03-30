package com.example.demo_jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name ="courses")
public class Course {
    private Integer idCourse;
    private String description;
    private String Career;
    private Integer year;
    private Integer quarter;
    @OneToMany
    private List<Student> students;
}
