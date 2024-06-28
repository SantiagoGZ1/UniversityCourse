package com.example.Cursos.universidad.Repo;

import com.example.Cursos.universidad.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CoursesRepo extends JpaRepository<Courses, Long> {
}
