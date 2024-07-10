package com.example.Cursos.universidad;

import com.example.Cursos.universidad.Exceptions.GeneralException;
import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import com.example.Cursos.universidad.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class StudentTest {
  //Agregar dependencia de la clase a testear
  //Se ponen estás dos porque son las que hay en studentService
  private StudentsRepo studentsRepo;
  private StudentService studentService;

//crear dependencias del test
//instancias dependencias para que la clase principal funcione
  @BeforeEach()
  public void setUp() {
    //mock -> simulación con datos
    this.studentsRepo = mock(StudentsRepo.class); //se debe hacer mock a todos lo externo a la app (bases de datos, llamadas a otras apis, etc)
    this.studentService = new StudentService(studentsRepo);
    //el constructor de studentService necesita un repo
  }

  //Generar casos de prueba

  //Arrange -> preparar datos
  //act -> acción -> invocar metodo a testear
  //Asser -> testear que espero y el resultado

  @Test
  public void underageStudent(){

    Student underageStudent = new Student(1223L,"Jose", "maria", LocalDate.of(2007,1,12));
    //La "L" indica que el dato debe ser tratado como long

    //Act & Assert
    //al manejar exceptions
    //exception esperada - de donde sale
    Exception e = assertThrows(GeneralException.class, () -> this.studentService.createStudent(underageStudent));
    //test de mensaje
    assertEquals("You are a minor, you can't enter university", e.getMessage());
  }

  @Test
  public void adult(){
    //Arrange -> preparar datos
    Student adult = new Student(1223L,"Jose", "maria", LocalDate.of(2000,1,12));
    //act
    studentService.createStudent(adult);
    //Assert
    verify(studentsRepo, times(1)).save(adult);
  }

  @Test
  public void getStudentNoExist(){
    Student student = new Student(1223L,"Jose", "maria", LocalDate.of(2007,1,12));

    Exception e = assertThrows(GeneralException.class, () -> this.studentService.getStudent(student.getId()));

    assertEquals("Holi, estamos intentando sin éxito hacer esto", e.getMessage());


  }

  @Test
  //Arrange -> preparar datos
  public void getStudentPresent(){
    Student student1 = new Student(1223L,"Jose", "maria", LocalDate.of(2000,1,12));

    when(studentsRepo.findById(student1.getId())).thenReturn(Optional.of(student1));
    //act
    Student result = studentService.getStudent(student1.getId());
    //Assert
    verify(studentsRepo, times(1)).findById(student1.getId());

  }

  @Test
  public void AllStudents(){
    //arrange
    List<Student> students = new ArrayList<>();
    //act
    List<Student> result = studentService.getAllStudents();
    //Assert
    verify(studentsRepo, times(1)).findAll();
  }


  @Test
  public void deleteStudent(){
    //arrange
    Student student = new Student(1223L,"Jose", "maria", LocalDate.of(2000,1,12));
    when(studentsRepo.findById(student.getId())).thenReturn(Optional.of(student));
    //act
    studentService.deleteStudent(student.getId());
    verify(studentsRepo,times(1)).delete(student);

  }

  @Test
  public void deleteNoExist(){
    Student student = new Student(1223L,"Jose", "maria", LocalDate.of(2007,1,12));

    Exception e =  assertThrows(GeneralException.class, () -> this.studentService.deleteStudent(student.getId()));

    assertEquals("Holi, estamos intentando sin éxito hacer esto", e.getMessage());

  }
}
