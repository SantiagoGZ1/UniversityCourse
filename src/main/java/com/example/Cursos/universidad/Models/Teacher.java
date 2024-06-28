package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
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
}
