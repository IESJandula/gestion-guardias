package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.ProfesorDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.AsignaturaRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.GrupoRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public void guardarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> obtenerProfesor(String email) {
        return profesorRepository.findByEmail(email);
    }

    @Transactional
    public void actualizarProfesor(Long profesorId, ProfesorDTO profesorDTO) {
        Optional<Profesor> profesorOpt = profesorRepository.findById(profesorId);  // Usar el id recibido como parámetro
        if (profesorOpt.isPresent()) {
            Profesor profesor = profesorOpt.get();
            profesor.setNombre(profesorDTO.getNombre());
            profesor.setEmail(profesorDTO.getEmail());

            Long asignaturaId = Long.valueOf(profesorDTO.getAsignatura());
            Long grupoId = Long.valueOf(profesorDTO.getGrupo());

            // Buscar la asignatura y el grupo en el repositorio
            Asignatura asignatura = asignaturaRepository.findById(asignaturaId)
                    .orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada"));

            Grupo grupo = grupoRepository.findById(grupoId)
                    .orElseThrow(() -> new EntityNotFoundException("Grupo no encontrado"));

            // Actualizar las asignaturas y el grupo del profesor
            profesor.setAsignaturas(Collections.singletonList(asignatura));  // Debe ser una lista
            profesor.setGrupo(Collections.singletonList(grupo));  // Debe ser una lista

            profesorRepository.save(profesor);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado");
        }
    }


    @Transactional
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }
}
