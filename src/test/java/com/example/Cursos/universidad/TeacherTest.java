package com.example.Cursos.universidad;

import com.example.Cursos.universidad.Models.Teacher;
import com.example.Cursos.universidad.Repo.StudentsRepo;
import com.example.Cursos.universidad.Repo.TeachersRepo;
import com.example.Cursos.universidad.Service.TeacherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.Mockito.*;

public class TeacherTest {

    private TeachersRepo teachersRepo;
    private TeacherService teacherService;

    @BeforeEach
     public void setUp() {

        this.teachersRepo = mock(TeachersRepo.class);
        this.teacherService = new TeacherService(teachersRepo);

    }

    @Test
    public void createTeacher() {
        Teacher teacher = new Teacher(1212L, "Mateo", "Zapata", Collections.singletonList("Ing Software"), LocalDate.of(2023, 12, 1));

        teacherService.createTeacher(teacher);

        verify(teachersRepo, times(1)).save(teacher);

    }

    @Test
    public void getTeacher(){

    }


}
