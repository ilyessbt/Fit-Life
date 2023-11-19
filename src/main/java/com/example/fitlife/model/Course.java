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
  private Boolean availability;
  private String time;
  private Long spots;

  public String getStart_time() {
    return time;
  }

  public void setStart_time(String time) {
    this.time = time;
  }

  public Long getSpots() {
    return spots;
  }

  public void setSpots(Long spots) {
    this.spots = spots;
  }

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



  public Boolean getAvailability() {
    return availability;
  }

  public void setAvailability(Boolean availability) {
    this.availability = availability;
  }


}
