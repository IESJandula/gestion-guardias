package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AusenciaRepository extends JpaRepository<Ausencia, Long> {
}
