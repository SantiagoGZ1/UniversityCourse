package com.example.Cursos.universidad.Repo;

import com.example.Cursos.universidad.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface StudentsRepo extends JpaRepository <Student, Long> {

}
