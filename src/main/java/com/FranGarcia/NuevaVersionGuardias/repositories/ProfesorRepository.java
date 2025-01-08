package com.FranGarcia.NuevaVersionGuardias.repositories;

import com.FranGarcia.NuevaVersionGuardias.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {
    Optional<Profesor> findByEmail(String email);
}
