package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher") public class Teacher {
    @Id
    private int id;
    private String name;
    @ManyToMany(mappedBy = "teacherSet" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> courseSet = new HashSet<>();

    public Teacher() {
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
        this.courseSet = new HashSet<>();
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
}
