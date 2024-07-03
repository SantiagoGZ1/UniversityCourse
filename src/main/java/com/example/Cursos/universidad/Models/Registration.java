package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class Registration {

  @Id
  @Column(name = "coursesRegistrarion_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private LocalDate registerDate;
  @Column
  private LocalDate unregisterDate;

  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
  private Courses courses;

  public Registration(Long id, LocalDate registerDate, LocalDate unregisterDate, Student student, Courses courses) {
    this.id = id;
    this.registerDate = registerDate;
    this.unregisterDate = unregisterDate;
    this.student = student;
    this.courses = courses;
  }

  public Registration(Long id, LocalDate registerDate, LocalDate unregisterDate, Courses courses) {
    this.id = id;
    this.registerDate = registerDate;
    this.unregisterDate = unregisterDate;
    this.courses = courses;
  }

  public Registration() {
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setRegisterDate(LocalDate registerDate) {
    this.registerDate = registerDate;
  }

  public void setUnregisterDate(LocalDate unregisterDate) {
    this.unregisterDate = unregisterDate;
  }

  public void setStudent(Student student) {
    this.student = student;
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

  public Student getStudents() {
    return student;
  }

  public Courses getCourses() {
    return courses;
  }
}
