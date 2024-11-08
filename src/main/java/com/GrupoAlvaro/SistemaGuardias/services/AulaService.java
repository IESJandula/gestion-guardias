package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Aula;
import com.GrupoAlvaro.SistemaGuardias.repositories.AulaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;


    @Transactional
    public void guardarAula(Aula aula) {
        aulaRepository.save(aula);
    }

    public List<Aula> listaAulas() {
        return aulaRepository.findAll();
    }

    public Optional<Aula> buscarAulaById(Long id) {
        return aulaRepository.findById(id);
    }

    @Transactional
    public void eliminarAula(Long id) {
        aulaRepository.deleteById(id);
    }

    @Transactional
    public Optional<Aula> actualizarAula(Long id, Aula aulaActualizada) {
        Optional<Aula> aula = aulaRepository.findById(id);
        if (aula.isPresent()) {
            aula.get().setNombre(aulaActualizada.getNombre());
            aula.get().setUbicacion(aulaActualizada.getUbicacion());
        }else {
            throw new ResourceNotFoundException("Aula no encontrada");
        }
        return aula;
    }


}
