package com.FranGarcia.NuevaVersionGuardias.repositories;

import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import com.FranGarcia.NuevaVersionGuardias.models.Cobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Long> {

    //metodo que servira para verificar si un profesor ya esta asignado a una cobertura en la misma fecha y hora
    boolean existsByProfesorCubreEmailAndAusenciaFechaAndAusenciaHora(String profesorEmail, LocalDate fecha, HoraDia hora);

    @Query("SELECT c FROM Cobertura c WHERE c.ausencia.fecha = :fecha")
    List<Cobertura> findByFecha(@Param("fecha") LocalDate fecha);

}
