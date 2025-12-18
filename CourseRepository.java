package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> { }
