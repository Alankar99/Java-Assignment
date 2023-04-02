package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course
{
    @Id
    private int id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Teacher> teacherSet = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Student> studentSet = new HashSet<>();

    public Course() {
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.teacherSet = new HashSet<>();
        this.studentSet = new HashSet<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeacherSet() {
        return teacherSet;
    }

    public void setTeacherSet(Set<Teacher> teacherSet) {
        this.teacherSet = teacherSet;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
