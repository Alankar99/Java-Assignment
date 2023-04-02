package com.example.demo.controller;

import com.example.demo.entities.Teacher;
import com.example.demo.repositories.TeacherRepository;
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
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/allTeachers")
    public ResponseEntity<List<Teacher>> getAllTeachers()
    {
        List<Teacher> teacher = new ArrayList<>();

        teacher.addAll(teacherRepository.findAll());

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Integer id)
    {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Teacher with the specified ID was not Found"));
        return new ResponseEntity<>(teacher , HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher)
    {
        Teacher newTeacher = teacherRepository.save(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }
    @PutMapping("/teacher/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable("id") Integer id, @RequestBody Teacher teacher)
    {
        Teacher updatedTeacher = teacherRepository.findById(id).orElseThrow(()->new ResourceAccessException("Teacher with id "+id+ " not found"));

        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setName(teacher.getName());
        updatedTeacher.setCourseSet(teacher.getCourseSet());

        return new ResponseEntity<>(teacherRepository.save(updatedTeacher) , HttpStatus.OK);
    }

    public ResponseEntity<Teacher> deleteTeacher(@PathVariable("id") Integer id)
    {
        teacherRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
