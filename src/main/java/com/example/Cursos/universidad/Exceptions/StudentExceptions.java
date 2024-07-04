package com.example.Cursos.universidad.Exceptions;

public class StudentExceptions extends RuntimeException{
  public StudentExceptions(String message) {
    super(message);
  }

  public StudentExceptions(String message, Throwable cause) {
    super(message, cause);
  }
}

