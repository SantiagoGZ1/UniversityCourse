package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Teacher {
  @Id
  @Column(name = "teacher_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String lastName;

  @Column
  private List <String> academyTitles;

  @Column
  private LocalDate startWork;

  @OneToMany(mappedBy = "teacher")
  private  List<Courses> courses = new ArrayList<>();


  public Teacher(Long id, String name, String lastName, List<String> academyTitles, LocalDate startWork) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.academyTitles = academyTitles;
    this.startWork = startWork;
  }

  public Teacher() {
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

  public List<String> getAcademyTitles() {
    return academyTitles;
  }

  public LocalDate getStartWork() {
    return startWork;
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

  public void setAcademyTitles(List<String> academyTitles) {
    this.academyTitles = academyTitles;
  }

  public void setStartWork(LocalDate startWork) {
    this.startWork = startWork;
  }

  public void setCourses(List<Courses> courses) {
    this.courses = courses;
  }
}
