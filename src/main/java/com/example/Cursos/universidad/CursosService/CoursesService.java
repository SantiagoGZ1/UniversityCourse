package com.example.Cursos.universidad.CursosService;

import com.example.Cursos.universidad.Models.Courses;
import com.example.Cursos.universidad.Repo.CoursesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CoursesService {
  private CoursesRepo coursesRepo;

  @Autowired
  public CoursesService(CoursesRepo coursesRepo) {
    this.coursesRepo = coursesRepo;
  }

  //Basic Logic

  public void createSertvice (Courses courses){
    this.coursesRepo.save(courses);
  }

  public Courses getCourse (Long id){
    Optional<Courses> coursesOptional = this.coursesRepo.findById(id);
    if (coursesOptional.isPresent()){
      return coursesOptional.get();
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found");
  }
}
