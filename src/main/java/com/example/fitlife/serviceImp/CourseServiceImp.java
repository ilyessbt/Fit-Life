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
import java.util.Optional;

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
  @Override
  public void deleteCourse(Long courseId) {
    courseRepo.deleteById(courseId);
  }

  @Override
  public Course updateCoursePartial(Long courseId, Course updatedCourse) {
    Optional<Course> existingCourseOptional = courseRepo.findById(courseId);

    if (existingCourseOptional.isPresent()) {
      Course existingCourse = existingCourseOptional.get();

      if (updatedCourse.getTitle() != null) {
        existingCourse.setTitle(updatedCourse.getTitle());
      }

      if (updatedCourse.getStart_date() != null) {
        existingCourse.setStart_date(updatedCourse.getStart_date());
      }

      if (updatedCourse.getEnd_date() != null) {
        existingCourse.setEnd_date(updatedCourse.getEnd_date());
      }

      if (updatedCourse.getAvailability() != null) {
        existingCourse.setAvailability(updatedCourse.getAvailability());
      }

      if (updatedCourse.getStart_time() != null) {
        existingCourse.setStart_time(updatedCourse.getStart_time());
      }

      if (updatedCourse.getEnd_time() != null) {
        existingCourse.setEnd_time(updatedCourse.getEnd_time());
      }

      if (updatedCourse.getCoach() != null) {
        existingCourse.setCoach(updatedCourse.getCoach());
      }

      return courseRepo.save(existingCourse);
    } else {
      return null;
    }
  }

}
