package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Student {

  @Id
  @Column(name = "student_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String lastName;
  @Column
  private String birthdate;

  @OneToMany(mappedBy = "student")
  private List<CourseRegistration> courseRegistration = new ArrayList<>();

  public Student(Long id, String name, String lastName, String birthdate) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.birthdate = birthdate;
  }

//  public Student(Long id, String name, String lastName, LocalDate birthdate, CourseRegistration courseRegistration) {
//    this.id = id;
//    this.name = name;
//    this.lastName = lastName;
//    this.birthdate = birthdate;
//    this.courseRegistration = courseRegistration;
//  }

  public Student() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getLastName() {
    return lastName;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

//  public void setCourseRegistration(CourseRegistration courseRegistration) {
//    this.courseRegistration = courseRegistration;
//  }
}