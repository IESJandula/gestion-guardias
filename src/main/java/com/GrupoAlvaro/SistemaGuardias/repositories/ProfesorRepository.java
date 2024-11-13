package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    Optional<Profesor> findByEmail(String profesorEmail);
}
