package com.example.fitlife.repository;

import com.example.fitlife.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface CourseRepo extends JpaRepository<Course,Long> {
  @Query("SELECT c FROM Course c WHERE c.start_date BETWEEN :start AND :end")
  List<Course> findCoursesBetweenDates(@Param("start") LocalDate start, @Param("end") LocalDate end);
}
