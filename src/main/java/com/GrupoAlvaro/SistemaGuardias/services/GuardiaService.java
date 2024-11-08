package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Guardia;
import com.GrupoAlvaro.SistemaGuardias.repositories.GuardiaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardiaService {

    @Autowired
    private GuardiaRepository guardiaRepository;

    public List<Guardia> findAll(){
        return guardiaRepository.findAll();
    }

    public Optional<Guardia> findById(Long id){
        return Optional.ofNullable(guardiaRepository.findById(id));
    }

    @Transactional
    public Guardia save(Guardia guardia){
        return guardiaRepository.save(guardia);
    }

    @Transactional
    public void deleteById(Long id){
        guardiaRepository.delete(id);
    }

    @Transactional
    public Guardia update(Guardia guardia){
        Guardia guardiaAux = guardiaRepository.findById(guardia.getId());

        return guardiaAux;
    }
}
