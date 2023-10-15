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
  public Map<String, LocalDate> getCurrentWeekDates() {
    LocalDate today = LocalDate.now();
    LocalDate startOfWeek = today.with(DayOfWeek.MONDAY);
    LocalDate endOfWeek = startOfWeek.plusDays(6);

    Map<String, LocalDate> weekDates = new HashMap<>();
    weekDates.put("startOfWeek", startOfWeek);
    weekDates.put("endOfWeek", endOfWeek);

    return weekDates;
  }

  @Override
  public List<Course> getCoursesForCurrentWeek(){
    Map<String, LocalDate> weekDates = getCurrentWeekDates();
    LocalDate startOfWeek = weekDates.get("startOfWeek");
    LocalDate endOfWeek = weekDates.get("endOfWeek");

    return courseRepo.findCoursesBetweenDates(startOfWeek, endOfWeek);
  }

  @Override
  public Course createCourse(Course course) {
    return courseRepo.save(course);
  }
}
