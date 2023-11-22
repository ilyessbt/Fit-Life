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


@CrossOrigin("*")
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

  @PostMapping("/create")
  public Course createCourse(@RequestBody Course course) {
    return courseService.createCourse(course);
  }

  @DeleteMapping("/{courseId}")
  public void deleteCourse(@PathVariable Long courseId) {
    courseService.deleteCourse(courseId);
  }

  @PatchMapping("/{courseId}")
  public Course updateCoursePartial(@PathVariable Long courseId, @RequestBody Course updatedCourse) {
    return courseService.updateCoursePartial(courseId, updatedCourse);
  }
}