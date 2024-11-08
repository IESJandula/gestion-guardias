package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Asignacion;
import com.GrupoAlvaro.SistemaGuardias.repositories.AsignacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Transactional
    public void guardarAsignacion(Asignacion asignacion) {
        asignacionRepository.save(asignacion);
    }

    public List<Asignacion> listarAsignaciones() {
        return asignacionRepository.findAll();
    }

    @Transactional
    public void eliminarAsignacion(Long asignacionId) {
        asignacionRepository.deleteById(asignacionId);
    }

    @Transactional
    public Asignacion modificarAsignacion(Long asignacionId, Asignacion asignacionActualizda) {
        Optional<Asignacion> asignacion = asignacionRepository.findById(asignacionId);
        if (asignacion.isPresent()) {
            asignacion.get().setTipoAsignacion(asignacionActualizda.getTipoAsignacion());
            asignacion.get().setAula(asignacionActualizda.getAula());
            asignacion.get().setAusencia(asignacionActualizda.getAusencia());
            asignacion.get().setHora(asignacionActualizda.getHora());
            asignacion.get().setProfesor(asignacionActualizda.getProfesor());
            asignacion.get().setDiaSemana(asignacionActualizda.getDiaSemana());
            return asignacionRepository.saveAndFlush(asignacion.get());
        }else{
            throw new ResourceNotFoundException("Asignacion no encontrada");
        }
    }


}
