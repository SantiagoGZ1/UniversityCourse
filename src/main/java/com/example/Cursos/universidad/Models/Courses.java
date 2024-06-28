package com.example.Cursos.universidad.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table
public class Courses {

  @Id
  @Column(name = "courses_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String name;

  @Column
  private String description;

  @Column
  private String subject;

  @ManyToOne
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
  private Teacher teacher;


  public Courses(Long id, String name, String description, String subject, Teacher teacher) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.subject = subject;
    this.teacher = teacher;
  }

  public Courses() {
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getSubject() {
    return subject;
  }

  public Teacher getTeacher() {
    return teacher;
  }

}
