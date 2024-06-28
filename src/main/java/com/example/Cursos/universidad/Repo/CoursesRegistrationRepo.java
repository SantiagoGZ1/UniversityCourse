package com.example.Cursos.universidad.Repo;

import com.example.Cursos.universidad.Models.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursesRegistrationRepo extends JpaRepository<CourseRegistration, Long> {
}
