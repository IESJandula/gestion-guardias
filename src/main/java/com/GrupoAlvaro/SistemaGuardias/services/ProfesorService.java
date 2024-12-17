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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@CacheConfig(cacheNames = {"profesores"})
@Service
public class ProfesorService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Transactional
    public void guardarProfesor(ProfesorDTO profesorDTO) {
        Profesor profesor = new Profesor();
        profesor.setNombre(profesorDTO.getNombre());
        profesor.setEmail(profesorDTO.getEmail());
        profesor.setAsignaturas(profesorDTO.getAsignatura());
        profesor.setGrupo(profesorDTO.getGrupo());
        profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Cacheable(key = "#email")
    public Optional<Profesor> obtenerProfesor(String email) {
        return profesorRepository.findByEmail(email);
    }

    @Transactional
    @CachePut(key = "#profesorId")
    public void actualizarProfesor(Long profesorId, ProfesorDTO profesorDTO) {
        Optional<Profesor> profesorOpt = profesorRepository.findById(profesorId); // Usar el id recibido como parámetro
        if (profesorOpt.isPresent()) {
            Profesor profesor = profesorOpt.get();
            profesor.setNombre(profesorDTO.getNombre());
            profesor.setEmail(profesorDTO.getEmail());

            List asignaturaId = profesorDTO.getAsignatura();
            List grupoId = profesorDTO.getGrupo();

            profesorRepository.save(profesor);
        } else {
            throw new EntityNotFoundException("Profesor no encontrado");
        }
    }

    @Transactional
    @CacheEvict(key = "#id")
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

}
