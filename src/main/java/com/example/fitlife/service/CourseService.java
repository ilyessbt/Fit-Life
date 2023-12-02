package com.example.fitlife.service;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public interface CourseService {
  Course getCourseById(Long id);
  List<Course> getAllCourses();
  String[] getCurrentWeekDates();
  Long countCourse();
  Course createCourse(Course course);
  void deleteCourse(Long courseId);
  Course updateCoursePartial(Long courseId, Course updatedCourse);
}
