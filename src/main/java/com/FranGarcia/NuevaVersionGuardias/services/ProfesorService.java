package com.FranGarcia.NuevaVersionGuardias.services;

import com.FranGarcia.NuevaVersionGuardias.models.Profesor;
import com.FranGarcia.NuevaVersionGuardias.repositories.ProfesorRepository;
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

    public Optional<Profesor> findByEmail(String email) {
        return profesorRepository.findByEmail(email);
    }

    @Transactional
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }


}
