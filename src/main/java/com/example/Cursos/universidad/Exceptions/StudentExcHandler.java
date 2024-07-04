package com.example.Cursos.universidad.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class StudentExcHandler {
  public StudentExcHandler() {
  }

  @ExceptionHandler({StudentExceptions.class})
  public ResponseEntity<Object> handleStudentExceptions(StudentExceptions e) {
    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    ApiException apiException = new ApiException(e.getMessage(), badRequest, e, ZonedDateTime.now(ZoneId.of("Z")));
    return new ResponseEntity(apiException, badRequest);
  }
}
