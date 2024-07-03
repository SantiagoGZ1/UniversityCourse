package com.example.Cursos.universidad.Service;

import com.example.Cursos.universidad.Models.Courses;
import com.example.Cursos.universidad.Repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CoursesService {
  private CoursesRepo coursesRepo;

  @Autowired
  public CoursesService(CoursesRepo coursesRepo) {
    this.coursesRepo = coursesRepo;
  }

  //Basic Logic

  public void createCourse(Courses courses) {
    this.coursesRepo.save(courses);
  }

  public Courses getCourse(Long id) {
    Optional<Courses> coursesOptional = this.coursesRepo.findById(id);
    if (coursesOptional.isPresent()) {
      return coursesOptional.get();
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
  }

  public List<Courses> getAllCourses() {
    return this.coursesRepo.findAll();
  }

  public void deleteCourses(Long id) {
    Optional<Courses> courseOptional = this.coursesRepo.findById(id);
    if (courseOptional.isEmpty()) {
      System.out.println("Course does not exist");
    } else {
      this.coursesRepo.delete(courseOptional.get());
    }
  }

  public Courses updateCourses(Long id, Courses course) {
    Optional<Courses> coursesOptional = this.coursesRepo.findById(id);
    if (coursesOptional.isPresent()) {
      Courses courseToUpdate = coursesOptional.get();
      courseToUpdate.setName(course.getName());
      courseToUpdate.setDescription(course.getDescription());
      courseToUpdate.setSubject(course.getSubject());
      courseToUpdate.setTeacher(course.getTeacher());
      return coursesRepo.save(courseToUpdate);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
    }
  }
}
