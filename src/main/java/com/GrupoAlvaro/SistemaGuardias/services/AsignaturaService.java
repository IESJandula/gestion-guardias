package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignaturaDTO;
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
    public void guardarAsignatura(Asignatura asignatura) {

        asignaturaRepository.save(asignatura);
    }

    public List<Asignatura> listarAsignaturas() {
        return asignaturaRepository.findAll();
    }


    public Optional<Asignatura> obtenerAsignatura(Long id) {
        return asignaturaRepository.findById(id);
    }


    @Transactional
    public void eliminarAsignatura(Long id) {
        asignaturaRepository.deleteById(id);
    }

    @Transactional
    public void actualizarAsignatura(Long id, AsignaturaDTO asignaturaDTO) {
        Optional<Asignatura> asignaturaOpt = asignaturaRepository.findById(id);
        if (asignaturaOpt.isPresent()) {
            Asignatura asignatura = asignaturaOpt.get();
            asignatura.setNombre(asignaturaDTO.getNombre());
            asignaturaRepository.save(asignatura);
        }
    }

}
