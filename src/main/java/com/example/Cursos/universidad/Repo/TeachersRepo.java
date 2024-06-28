package com.example.Cursos.universidad.Repo;

import com.example.Cursos.universidad.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TeachersRepo extends JpaRepository<Teacher, Long> {
}
