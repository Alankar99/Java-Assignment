package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.*;
@Entity
@Table(name = "student") public class Student {

    @Id
    private int id;
    private String name;
    private String batch;
    private String date_of_birth;
    @ManyToMany(mappedBy = "studentSet",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Course> courseSet = new HashSet<>();

    public Student() {
    }

    public Student(int id, String name, String batch, String date_of_birth) {
        this.id = id;
        this.name = name;
        this.batch = batch;
        this.date_of_birth = date_of_birth;
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

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }
}
