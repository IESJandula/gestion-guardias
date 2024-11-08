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

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> findAll() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> findById(Long id) {
        return profesorRepository.findById(id);
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
