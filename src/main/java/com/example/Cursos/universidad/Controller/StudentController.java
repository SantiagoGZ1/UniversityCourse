package com.example.Cursos.universidad.Controller;

import com.example.Cursos.universidad.Service.StudentService;
import com.example.Cursos.universidad.Models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  //----
  @PostMapping()
  public ResponseEntity<String> createStudent(@RequestBody Student student){
    try {
      this.studentService.createStudent(student);
      return ResponseEntity.ok("Se creó el estudiante");
    }catch (Exception e){ //el mensaje del error del exception
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: No se pudo crear el estudiate " + e.getMessage());
    }
  }
  @GetMapping("/{id_student}")
  public Student getStudent(@PathVariable("id_student")Long id){
    return this.studentService.getStudent(id);
  }

  @GetMapping("/students")
  public List<Student> getAllStudent(){
    return this.studentService.getAllStudents();
  }

  @DeleteMapping("/{id_student}")
  public void deleteStudent(@PathVariable("id_student")Long id){
    this.studentService.deleteStudent(id);
    System.out.println("El estudiante se eliminó correctamente");
  }

  @PutMapping("/{id_student}")
  public Student updateStudent (@PathVariable("id_student")Long id, @RequestBody Student student){
    return this.studentService.updateStudent(id, student);
  }

}
