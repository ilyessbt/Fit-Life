package com.example.fitlife.service;

import com.example.fitlife.model.Course;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public interface CourseService {
  List<Course> getAllCourses();
  String[] getCurrentWeekDates();
  List<Course> getCoursesForCurrentWeek();
  Course createCourse(Course course);
}
