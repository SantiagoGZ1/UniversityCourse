package com.example.Cursos.universidad.Controller;


import com.example.Cursos.universidad.Service.CoursesService;
import com.example.Cursos.universidad.Models.Courses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CoursesController {

    private CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @PostMapping()
    public ResponseEntity<String> createCourse(@RequestBody Courses course){
        try {
            this.coursesService.createCourse(course);
            return ResponseEntity.ok("Se creó el curso");
        }catch (Exception e){ //el mensaje del error del exception
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: No se pudo crear el curso " + e.getMessage());
        }
    }
    @GetMapping("/{id_Course}")
    public Courses getCourse(@PathVariable("id_Course")Long id){
        return this.coursesService.getCourse(id);
    }

    @GetMapping("/courses")
    public List<Courses> getAllStudent(){
        return this.coursesService.getAllCourses();
    }

    @DeleteMapping("/{id_course}")
    public void deleteCourse(@PathVariable("id_course")Long id){
        this.coursesService.deleteCourses(id);
        System.out.println("El curso se eliminó correctamente");
    }

   @PutMapping("/{id_course}")
    public Courses updateCourse (@PathVariable("id_courses")Long id, @RequestBody Courses course){
        return this.coursesService.updateCourses(id, course);
    }


}
