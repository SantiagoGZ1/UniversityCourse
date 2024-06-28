package com.example.Cursos.universidad.CursosService;

import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private StudentsRepo studentsRepo;

  @Autowired
  public StudentService(StudentsRepo studentsRepo) {
    this.studentsRepo = studentsRepo;
  }

  //Logica

  public void createStudent (Student student){

    this.studentsRepo.save(student);
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
      System.out.println("No existe ele estudiante");
    }else {
      this.studentsRepo.delete(studentOptional.get());
    }
  }

  //update
  public Student updateStudent(Long id, Student student){
    Optional<Student> studentOptional =this.studentsRepo.findById(id);

    if(studentOptional.isPresent()){
      studentOptional.map(student1 -> {
        student1.setName(student.getName());
        student1.setLastName(student.getLastName());
        student1.setBirthdate(student.getBirthdate());
        return studentsRepo.save(student1);
      });
    }else {
      System.out.println("No se encontró el muchacho");
      return new Student();
    }
    return student;
  }
}
