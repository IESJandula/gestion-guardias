package com.FranGarcia.NuevaVersionGuardias.services;

import com.FranGarcia.NuevaVersionGuardias.enums.Actividad;
import com.FranGarcia.NuevaVersionGuardias.enums.DiaSemana;
import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import com.FranGarcia.NuevaVersionGuardias.models.*;
import com.FranGarcia.NuevaVersionGuardias.repositories.CoberturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CoberturaService {
    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private CoberturaRepository coberturaRepository;

    public List<Cobertura> obtenerCoberturasPorFecha(LocalDate fecha) {
        return coberturaRepository.findByFecha(fecha);
    }

    @Transactional
    public Cobertura generarCobertura(Ausencia ausencia) throws Exception {
        // Sacamos el día y la hora de la ausencia
        HoraDia hora = ausencia.getHora();
        DiaSemana diaSemana = DiaSemana.valueOf(ausencia.getFecha().getDayOfWeek().toString()); // Convertimos el día
        LocalDate fecha = ausencia.getFecha();

        // Obtenemos todos los profesores del centro
        List<Profesor> profesores = profesorService.findAll();

        // Recorremos los profesores para buscar disponibilidad
        for (Profesor profesor : profesores) {
            List<Horario> horarios = profesor.getHorarios();

            for (Horario horario : horarios) {
                // Validamos que coincida el día, la hora y la actividad de guardia
                if (horario.getDiaSemana() == diaSemana
                        && horario.getHoraDia() == hora
                        && horario.getActividad() == Actividad.GUARDIA) {

                    // Verificamos si el profesor ya está cubriendo una ausencia en este día y hora
                    boolean yaAsignado = coberturaRepository.existsByProfesorCubreEmailAndAusenciaFechaAndAusenciaHora(
                            profesor.getEmail(), fecha, hora);

                    if (!yaAsignado) {
                        // Creamos la cobertura y asociamos al profesor
                        Cobertura cobertura = new Cobertura();
                        cobertura.setAusencia(ausencia);
                        cobertura.setProfesorCubre(profesor);

                        // Guardamos y devolvemos la cobertura
                        return coberturaRepository.save(cobertura);
                    }
                }
            }
        }

        throw new Exception("No hay profesores disponibles para cubrir la guardia en esta fecha y hora.");
    }

}
