package com.example.fitlife.controller;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.service.CourseService;
import com.example.fitlife.serviceImp.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/courses")
public class CourseController {
  @Autowired
  private CourseServiceImp courseService;

  @GetMapping("/")
  public List<Course> getAllCourses() {
    return courseService.getAllCourses();
  }
  @GetMapping("/currentWeekDates")
  public  String[] getCurrentWeekDates() {
    return courseService.getCurrentWeekDates();
  }
  @GetMapping("/currentWeekCourses")
  public List<Course> getCoursesForCurrentWeek() {
    return courseService.getCoursesForCurrentWeek();
  }

  @PostMapping("/create")
  public Course createCourse(@RequestBody Course course) {
    return courseService.createCourse(course);
  }
}
