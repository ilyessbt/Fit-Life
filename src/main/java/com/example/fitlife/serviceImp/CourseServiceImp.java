package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.repository.CourseRepo;
import com.example.fitlife.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImp implements CourseService {
  @Autowired
  private CourseRepo courseRepo;

  @Override
  public List<Course> getAllCourses() {
    return courseRepo.findAll();
  }

  @Override
  public String[] getCurrentWeekDates() {
    LocalDate today = LocalDate.now();
    LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
    LocalDate endOfWeek = startOfWeek.plusDays(6);

    String[] weekDates = new String[2];
    weekDates[0] = startOfWeek.toString();
    weekDates[1] = endOfWeek.toString();

    return weekDates;
  }



  @Override
  public Course createCourse(Course course) {
    return courseRepo.save(course);
  }
}
