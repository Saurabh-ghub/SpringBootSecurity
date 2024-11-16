package com.example.security.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.security.models.Users;
import com.example.security.service.MyUserDetailsService;
import com.example.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
    @Autowired
    UserService userService;
    
    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users) {
        
        userService.saveUser(users);
        return users;
    }
    

}
