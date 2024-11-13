package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignaturaDTO;
import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.repositories.AsignaturaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Transactional
    public AsignaturaDTO guardarAsignatura(Asignatura asignaturaDTO) {

        return asignaturaDTO;
    }

    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }

    public Asignatura buscarAsignaturaById(Long id) {
        return asignaturaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Asignatura no encontrada"));
    }

    @Transactional
    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }

    @Transactional
    public Optional<Asignatura> actualizarAsignatura(Long id, Asignatura asignaturaModificada) {
        Optional<Asignatura> asignatura = asignaturaRepository.findById(id);
        if (asignatura.isPresent()) {
            asignatura.get().setNombre(asignaturaModificada.getNombre());
        }else {
            throw new ResourceNotFoundException("Asignatura no encontrada");
        }
        return asignatura;
    }



}
