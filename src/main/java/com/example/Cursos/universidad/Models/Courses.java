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

  @Column
  @OneToOne(mappedBy = "Teacher")
  @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
  private Teacher teacher;

  @Column
  @OneToMany(mappedBy = "Students", cascade = CascadeType.ALL)
  private List<Students> students = new ArrayList<>();

  public Courses(Long id, String name, String description, String subject, Teacher teacher, List<Students> students) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.subject = subject;
    this.teacher = teacher;
    this.students = students;
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

  public List<Students> getStudents() {
    return students;
  }
}
