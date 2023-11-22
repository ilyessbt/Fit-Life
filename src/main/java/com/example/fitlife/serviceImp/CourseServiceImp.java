package com.example.fitlife.serviceImp;

import com.example.fitlife.model.Course;
import com.example.fitlife.model.Customer;
import com.example.fitlife.repository.CourseRepo;
import com.example.fitlife.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
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

    String[] weekDates = new String[3];
    weekDates[0] = today.toString();
    weekDates[1] = startOfWeek.toString();
    weekDates[2] = endOfWeek.toString();

    return weekDates;
  }

  public List<Course> getCoursesForCurrentWeek() {
    String[] weekDates = getCurrentWeekDates();
    String startOfWeek = weekDates[0];
    String endOfWeek = weekDates[1];

    return courseRepo.findCoursesBetweenDates(startOfWeek, endOfWeek);
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


      if (updatedCourse.getAvailability() != null) {
        existingCourse.setAvailability(updatedCourse.getAvailability());


      if (updatedCourse.getStart_time() != null) {
        existingCourse.setStart_time(updatedCourse.getStart_time());
      }
      if (updatedCourse.getSpots() != null) {
        existingCourse.setSpots(updatedCourse.getSpots());

        if (existingCourse.getSpots() == 0) {
          existingCourse.setAvailability(false);
        } else {
          existingCourse.setAvailability(true);
        }

      }

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

