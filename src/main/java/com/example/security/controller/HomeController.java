package com.example.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.security.Student;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/")
public class HomeController {

    Student stud1 = new Student(0, "Saurabh", 94);
    Student stud2 = new Student(1, "Kishan", 85);
    List<Student> studs = new ArrayList<Student>(Arrays.asList(stud1,stud2));
    

    @GetMapping("/")
    public String getMethodName(HttpServletRequest httpServletRequest) {
        return "Welcome Home" + studs.toString() + httpServletRequest.getSession().getId();
    }
    
    @PostMapping("/")
    public ResponseEntity<Student> postMethodName(@RequestBody Student entity) {
        
        studs.add(entity);
        
        return new  ResponseEntity<>(entity,HttpStatus.OK);
    }
    
    @PostMapping(path = "/create")
    public Student addStudent(@RequestBody Student entity) {
        //TODO: process POST request
        // Student st = (Student)entity;      
        return entity;
    }
    
    
}
