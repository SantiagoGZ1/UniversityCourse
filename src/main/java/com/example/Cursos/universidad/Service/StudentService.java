package com.example.Cursos.universidad.Service;

import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private StudentsRepo studentsRepo;

  @Autowired
  public StudentService(StudentsRepo studentsRepo) {
    this.studentsRepo = studentsRepo;
  }

  //Basic Logic

  public void createStudent (Student student){

    if(student.getBirthdate().getYear() <= 2006){
      this.studentsRepo.save(student);
    } else {
      throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Sorry, student is too young");
    }

  }

  public Student getStudent (Long id){
    Optional<Student> studentOptional = this.studentsRepo.findById(id);
    if(studentOptional.isPresent()){
      return studentOptional.get();
    }
    return new Student();
  }

  //gest lista
  public List<Student> getAllStudents (){
    return this.studentsRepo.findAll();
  }

  //delete
  public void deleteStudent (Long id){
    Optional<Student> studentOptional = this.studentsRepo.findById(id);
    if(studentOptional.isEmpty()){
      System.out.println("The student does not exist");
    }else {
      this.studentsRepo.delete(studentOptional.get());
    }
  }

  //update
  public Student updateStudent(Long id, Student student) {
    Optional<Student> studentOptional = this.studentsRepo.findById(id);
    if (studentOptional.isPresent()) {
      Student studentToUpdate = studentOptional.get();
      if(student.getName() != null) {
        studentToUpdate.setName(student.getName());
      }

      if(student.getLastName() != null){
        studentToUpdate.setLastName(student.getLastName());
      }

      if(student.getBirthdate() != null){
        studentToUpdate.setBirthdate(student.getBirthdate());
      }
      return studentsRepo.save(studentToUpdate);
    } else {
      // Lanzar una excepción en lugar de devolver un nuevo Student vacío
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }
  }

}
