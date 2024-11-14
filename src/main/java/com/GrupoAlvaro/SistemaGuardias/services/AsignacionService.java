package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignacionDTO;
import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Asignacion;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.AsignacionRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Transactional
    public AsignacionDTO guardarAsignacion(AsignacionDTO asignacionDTO) {

        return asignacionDTO;
    }

    @Transactional
    public void eliminarAsignacion(Long asignacionId) {
        Optional<Asignacion> asignacion = asignacionRepository.findById(asignacionId);
        if (asignacion.isPresent()) {
            asignacionRepository.deleteById(asignacionId);
        } else {
            throw new ResourceNotFoundException("Asignación no encontrada para ID: " + asignacionId);
        }
    }

    @Transactional
    public Asignacion modificarAsignacion(Long asignacionId, AsignacionDTO asignacionDTO) {
        Optional<Asignacion> asignacionOpt = asignacionRepository.findById(asignacionId);
        if (asignacionOpt.isPresent()) {
            Asignacion asignacion = asignacionOpt.get();

            // Obtener el objeto Profesor por ID y asignarlo
            Optional<Profesor> profesorOpt = profesorRepository.findById(asignacionDTO.getProfesorId());
            if (!profesorOpt.isPresent()) {
                throw new ResourceNotFoundException("Profesor no encontrado con ID: " + asignacionDTO.getProfesorId());
            }
            Profesor profesor = profesorOpt.get();

            // Actualizar los campos de la asignación
            asignacion.setTipoAsignacion(asignacionDTO.getTipoAsignacion());
            asignacion.setHora(asignacionDTO.getHora());
            asignacion.setProfesor(profesor); // Asignar el objeto Profesor
            asignacion.setDiaSemana(asignacionDTO.getDiaSemana());

            return asignacionRepository.save(asignacion);
        } else {
            throw new ResourceNotFoundException("Asignación no encontrada con ID: " + asignacionId);
        }
    }
}

