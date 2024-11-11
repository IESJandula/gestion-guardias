package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Transactional
    public void guardarProfesor(Profesor profesor) {
        profesorRepository.save(profesor);
    }

    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    public Profesor buscarProfesorById(Long id) {
        return profesorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profesor no encontrado"));
    }

    @Transactional
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    @Transactional
    public Optional<Profesor> actualizarProfesor(Long id, Profesor profesorModificado) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        if (profesor.isPresent()) {
            profesor.get().setNombre(profesorModificado.getNombre());
        }else {
            throw new ResourceNotFoundException("Profesor no encontrado");
        }
        return profesor;
    }
}
