package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
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

    public void crearGuardia(Guardia guardia) {
        guardiaRepository.save(guardia);
    }

    public List<Guardia> listarGuardias() {
        return guardiaRepository.findAll();
    }

    public Guardia buscarGuardiaPorId(Long id) {
        Optional<Guardia> guardia = guardiaRepository.findById(id);
        if (!guardia.isPresent()) {
            throw new ResourceNotFoundException("Guardia no encontrado");
        }else {
            return guardia.get();
        }
    }

    public void cancelarGuardia(Long id) {
        guardiaRepository.deleteById(id);
    }

    public Optional<Guardia> modificarGuardia(Long id, Guardia guardiaModificada) {
        Optional<Guardia> guardia = guardiaRepository.findById(id);
        if (guardia.isPresent()) {
            guardia.get().setDiaSemana(guardiaModificada.getDiaSemana());
            guardia.get().setHora(guardiaModificada.getHora());
            guardia.get().setAsignacion(guardiaModificada.getAsignacion());
            guardia.get().setHorario(guardiaModificada.getHorario());
            guardia.get().setProfesor(guardiaModificada.getProfesor());
            guardiaRepository.save(guardia.get());
            return guardia;
        }else{
            throw new ResourceNotFoundException("Guardia no encontrada");
        }
    }



}
