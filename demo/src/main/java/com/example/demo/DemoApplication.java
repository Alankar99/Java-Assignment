package com.example.demo;

import com.example.demo.entities.Course;
import com.example.demo.entities.Student;
import com.example.demo.entities.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello World");
	}
}
