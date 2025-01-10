package com.FranGarcia.NuevaVersionGuardias.repositories;

import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import com.FranGarcia.NuevaVersionGuardias.models.Ausencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AusenciaRepository extends JpaRepository<Ausencia, Long> {
    List<Ausencia> findByFecha(LocalDate fecha);
    List<Ausencia> findAllByProfesorAusenteEmail(String email);
    List<Ausencia> findByFechaAndHoraAndProfesorAusenteEmail(LocalDate fecha, HoraDia hora, String emailProfesor);
}
