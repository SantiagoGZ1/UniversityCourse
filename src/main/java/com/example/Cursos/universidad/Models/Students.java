package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Students {

  @Id
  @Column(name = "student_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String lastName;
  @Column
  private LocalDate birthdate;

  @ManyToOne
  @JoinColumn(name = "courses_id")
  private List<Courses> courses = new ArrayList<>();

  public Students(Long id, String name, String lastName, LocalDate birthdate) {
    this.id = id;
    this.name = name;
    this.lastName = lastName;
    this.birthdate = birthdate;
  }

  public Students() {
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

  public LocalDate getBirthdate() {
    return birthdate;
  }
}
