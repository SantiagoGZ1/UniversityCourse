package com.example.Cursos.universidad.Controller;


import com.example.Cursos.universidad.Service.TeacherService;
import com.example.Cursos.universidad.Models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    //----
    @PostMapping()
    public ResponseEntity<String> createStudent(@RequestBody Teacher teacher){
        try {
            this.teacherService.createTeacher(teacher);
            return ResponseEntity.ok("Se creó el profe");
        }catch (Exception e){ //el mensaje del error del exception
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Error: No se pudo crear el profesor " + e.getMessage());
        }
    }
    @GetMapping("/{id_teacher}")
    public Teacher getTeacher(@PathVariable("id_teacher")Long id){
        return this.teacherService.getTeacher(id);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllStudent(){
        return this.teacherService.getAllTeachers();
    }

    @DeleteMapping("/{id_teacher}")
    public void deleteTeacher(@PathVariable("id_teacher")Long id){
        this.teacherService.deleteTeacher(id);
        System.out.println("El Profesor se eliminó correctamente");
    }

    @PutMapping("/{id_teacher}")
    public Teacher updateTeacher (@PathVariable("id_teacher")Long id, @RequestBody Teacher teacher){
        return this.teacherService.updateTeacher(id, teacher);
    }

}
