package com.example.Cursos.universidad;

import com.example.Cursos.universidad.Exceptions.GeneralException;
import com.example.Cursos.universidad.Models.Student;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import com.example.Cursos.universidad.Service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

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
    //Arrange -> preparar datos
    Student underageStudent = new Student(1223L,"Jose", "maria", LocalDate.of(2007,1,12));
    //La "L" indica que el dato debe ser tratado como long

    //Act & Assert
    //al manejar exceptions
    //exception esperada - de donde sale
    Exception e = assertThrows(GeneralException.class, () -> this.studentService.createStudent(underageStudent));
    //test de mensaje
    assertEquals("You are a minor, you can't enter university", e.getMessage());

  }



}
