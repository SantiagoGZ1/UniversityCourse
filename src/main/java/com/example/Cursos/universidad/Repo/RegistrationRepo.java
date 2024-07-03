package com.example.Cursos.universidad.Repo;

import com.example.Cursos.universidad.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends JpaRepository<Registration, Long> {
}
