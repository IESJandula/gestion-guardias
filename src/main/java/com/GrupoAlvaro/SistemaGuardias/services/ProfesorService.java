package com.GrupoAlvaro.SistemaGuardias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> findByEmail(String email) {
        return profesorRepository.findById(email);
    }

    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public void deleteByEmail(String email) {
        profesorRepository.deleteById(email);
    }

    public Profesor updateProfesor(String email, Profesor updatedProfesor) {
        return profesorRepository.findById(email).map(profesor -> {
            profesor.setNombre(updatedProfesor.getNombre());
            profesor.setHorario(updatedProfesor.getHorario());
            profesor.setAusencias(updatedProfesor.getAusencias());
            profesor.setAsignacionesGuardia(updatedProfesor.getAsignacionesGuardia());
            profesor.setContadorSustituciones(updatedProfesor.getContadorSustituciones());
            return profesorRepository.save(profesor);
        }).orElse(null);
    }
}
