package com.example.demo.controller;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/api")
@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>> getAllCourses()
    {
        List<Course> course = new ArrayList<>();

        course.addAll(courseRepository.findAll());

        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @GetMapping("course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id)
    {
        Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Course with the specified ID was not Found"));
        return new ResponseEntity<>(course , HttpStatus.OK);
    }

    @PostMapping("/course")
    public ResponseEntity<Course> createCourse(@RequestBody Course course)
    {
        Course newCourse = courseRepository.save(course);
        return new ResponseEntity<>(newCourse, HttpStatus.CREATED);
    }
    @PutMapping("/course/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable("id") Integer id, @RequestBody Course course)
    {
        Course updatedCourse = courseRepository.findById(id).orElseThrow(()->new ResourceAccessException("Course with id "+id+ " not found"));

        updatedCourse.setName(course.getName());
        updatedCourse.setName(course.getName());
        updatedCourse.setStudentSet(course.getStudentSet());
        updatedCourse.setTeacherSet(course.getTeacherSet());

        return new ResponseEntity<>(courseRepository.save(updatedCourse) , HttpStatus.OK);
    }

    public ResponseEntity<Course> deleteCourse(@PathVariable("id") Integer id)
    {
        courseRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
