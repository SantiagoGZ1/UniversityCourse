package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table
public class CourseRegistration {

  @Id
  @Column(name = "coursesRegistrarion_id")
  private Long id;
  @Column
  private LocalDate registerDate;
  @Column
  private LocalDate unregisterDate;

  @ManyToOne
  @JoinColumn(name = "student_id", referencedColumnName = "student_id")
  private Student student;

 // @Column
//  @ManyToOne
//  @JoinColumn(name = "courses_id", referencedColumnName = "courses_id")
//  private Courses courses;

  public CourseRegistration(Long id, LocalDate registerDate, LocalDate unregisterDate, Student student) {
    this.id = id;
    this.registerDate = registerDate;
    this.unregisterDate = unregisterDate;
    this.student = student;
    //this.courses = courses;
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

  public Student getStudents() {
    return student;
  }

}
