package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class CourseRegistration {

  @Id
  @Column
  private Long id;
  @Column
  private LocalDate registerDate;
  @Column
  private LocalDate unregisterDate;
  @Column
  @OneToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Students students;
  @Column
  private Courses courses;

  public CourseRegistration(Long id, LocalDate registerDate, LocalDate unregisterDate, Students students, Courses courses) {
    this.id = id;
    this.registerDate = registerDate;
    this.unregisterDate = unregisterDate;
    this.students = students;
    this.courses = courses;
  }

  public CourseRegistration() {
  }

  public Long getId() {
    return id;
  }

  public LocalDate getRegisterDate() {
    return registerDate;
  }

  public LocalDate getUnregisterDate() {
    return unregisterDate;
  }

  public Students getStudents() {
    return students;
  }

  public Courses getCourses() {
    return courses;
  }
}
