package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
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
        return Optional.ofNullable(profesorRepository.findById(Long.parseLong(email)));
    }

    @Transactional
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Transactional
    public void deleteByEmail(String email) {
        profesorRepository.deleteById(Long.valueOf(email));
    }

}
