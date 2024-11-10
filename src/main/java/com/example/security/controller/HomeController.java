package com.example.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.security.Student;

import jakarta.servlet.http.HttpServletRequest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HomeController {

    Student stud1 = new Student(0, "Saurabh", 94);
    Student stud2 = new Student(1, "Kishan", 85);
    List<Student> studs = new ArrayList<Student>(Arrays.asList(stud1,stud2));
    

    @GetMapping("/")
    public String getMethodName(HttpServletRequest httpServletRequest) {
        return "Welcome Home" + httpServletRequest.getSession().getId();
    }
    
    @PostMapping("/")
    public Student postMethodName(@RequestBody Student entity) {
        //TODO: process POST request
        studs.add(entity);
        
        return entity;
    }
    
    
}
