package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Guardia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GuardiaRepository extends JpaRepository<Guardia, Long> {
    public Guardia save(Guardia guardia);
    public Guardia update(Guardia guardia);

    void delete(Long id);
}
