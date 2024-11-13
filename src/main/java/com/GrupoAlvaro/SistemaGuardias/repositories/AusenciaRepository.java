package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AusenciaRepository extends JpaRepository<Ausencia, Long> {
    List<Ausencia> findByProfesor(Profesor profesor);
}
