package com.example.fitlife.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String fullname;
  private String profilepic;
  private String phonenumber;
  private String email;
  private String password;
//  @ManyToMany(fetch = FetchType.EAGER)
//  @JoinTable(
//    name = "customer_course",
//    joinColumns = @JoinColumn(name = "customer_id"),
//    inverseJoinColumns = @JoinColumn(name = "course_id")
//  )
//  private List<Course> courses;

//  public List<Course> getCourses() {
//    return courses;
//  }
//
//  public void setCourses(List<Course> courses) {
//    this.courses = courses;
//  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getEmail() {
    return email;
  }

  public String getProfilepic() {
    return profilepic;
  }

  public void setProfilepic(String profilepic) {
    this.profilepic = profilepic;
  }

  public String getPhonenumber() {
    return phonenumber;
  }

  public void setPhonenumber(String phonenumber) {
    this.phonenumber = phonenumber;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
