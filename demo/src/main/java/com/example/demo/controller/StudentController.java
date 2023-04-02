package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
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
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/allStudents")
    public ResponseEntity<List<Student>> getAllStudents()
    {
        List<Student> student = new ArrayList<>();

        student.addAll(studentRepository.findAll());

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id)
    {
        Student student = studentRepository.findById(id).orElseThrow(()-> new ResourceAccessException("Student with the specified ID was not Found"));
        return new ResponseEntity<>(student , HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student newStudent = studentRepository.save(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student)
    {
        Student updatedStudent = studentRepository.findById(id).orElseThrow(()->new ResourceAccessException("Student with id "+id+ " not found"));

        updatedStudent.setName(student.getName());
        updatedStudent.setBatch(student.getBatch());
        updatedStudent.setDate_of_birth(student.getDate_of_birth());
        updatedStudent.setCourseSet(student.getCourseSet());

        return new ResponseEntity<>(studentRepository.save(updatedStudent) , HttpStatus.OK);
    }

    public ResponseEntity<Student> deleteStudent(@PathVariable("id") Integer id)
    {
        studentRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
