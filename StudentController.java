package com.example.springdemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.dto.StudentRequestDTO;
import com.example.springdemo.dto.StudentResponseDTO;
import com.example.springdemo.model.Course;
import com.example.springdemo.model.Student;
import com.example.springdemo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentResponseDTO create(@Valid @RequestBody StudentRequestDTO dto) {
    return service.createStudent(dto);
    }


    @GetMapping
    public List<StudentResponseDTO> getAll() {
    return service.getAll().stream()
        .map(student -> new StudentResponseDTO(
            student.getId(),
            student.getName(),
            student.getAge(),
            student.getCourses().stream()
                .map(Course::getCourseName)
                .toList()
        ))
        .toList();
    }

    @GetMapping("/{id}")
    public Student getOne(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "Deleted student " + id;
    }
}
