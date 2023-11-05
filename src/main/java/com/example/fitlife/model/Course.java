package com.example.fitlife.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private LocalDate start_date;
  private LocalDate end_date;
  private Boolean availability;
  private LocalTime start_time;
  private LocalTime end_time;

  @ManyToOne
  @JoinColumn(name = "coach_id")
  private Coach coach;

  public Coach getCoach() {
    return coach;
  }

  public void setCoach(Coach coach) {
    this.coach = coach;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public LocalDate getStart_date() {
    return start_date;
  }

  public void setStart_date(LocalDate start_date) {
    this.start_date = start_date;
  }

  public LocalDate getEnd_date() {
    return end_date;
  }

  public void setEnd_date(LocalDate end_date) {
    this.end_date = end_date;
  }

  public Boolean getAvailability() {
    return availability;
  }

  public void setAvailability(Boolean availability) {
    this.availability = availability;
  }

  public LocalTime getStart_time() {
    return start_time;
  }

  public void setStart_time(LocalTime start_time) {
    this.start_time = start_time;
  }

  public LocalTime getEnd_time() {
    return end_time;
  }

  public void setEnd_time(LocalTime end_time) {
    this.end_time = end_time;
  }
}
