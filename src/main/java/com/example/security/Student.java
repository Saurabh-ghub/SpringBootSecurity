package com.example.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    int id;
    String name;
    int score;

   
    public String toString(){
        return id+" " + name + " " + score;
    }

}
