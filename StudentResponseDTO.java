package com.example.springdemo.dto;

import java.util.List;

public class StudentResponseDTO {

    private Long id;
    private String name;
    private int age;
    private List<String> courses;

    public StudentResponseDTO(Long id, String name, int age, List<String> courses) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getCourses() { return courses; }
}
