package com.example.Cursos.universidad.CursosService;

import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Models.Teacher;
import com.example.Cursos.universidad.Repo.TeachersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
@Service
public class TeacherService {

  private TeachersRepo teachersRepo;

  @Autowired
  public TeacherService(TeachersRepo teachersRepo) {
    this.teachersRepo = teachersRepo;
  }

  //Basic Logic

  public void createTeacher (Teacher teacher){
    this.teachersRepo.save(teacher);
  }

  public Teacher getTeacher (Long id){
    Optional<Teacher> teacherOptional = this.teachersRepo.findById(id);
    if (teacherOptional.isPresent()){
      return teacherOptional.get();
    }
    return new Teacher();
  }

  public List<Teacher> getAllTeachers(){
    return this.teachersRepo.findAll();
  }
  public void deleteTeacher(Long id){
    Optional<Teacher> teacherOptional = this.teachersRepo.findById(id);
    if (teacherOptional.isEmpty()){
      System.out.println("The student does not exist");
    }else{
      this.teachersRepo.delete(teacherOptional.get());
    }
  }

  public Teacher updateTeacher(Long id, Teacher teacher){
    Optional<Teacher> teacherOptional = this.teachersRepo.findById(id);
    if(teacherOptional.isPresent()){
      Teacher teacherToUpdate = teacherOptional.get();
      teacherToUpdate.setName(teacher.getName());
      teacherToUpdate.setLastName(teacher.getLastName());
      teacherToUpdate.setAcademyTitles(teacher.getAcademyTitles());
      teacherToUpdate.setStartWork(teacher.getStartWork());
      return teachersRepo.save(teacherToUpdate);

    }else{
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
    }
  }
}







