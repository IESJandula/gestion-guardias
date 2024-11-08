package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Tarea;
import com.GrupoAlvaro.SistemaGuardias.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Optional<Tarea> findById(Long id) {
        return Optional.ofNullable(tareaRepository.findById(id));
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Transactional
    public void deleteById(Long id) {
        tareaRepository.deleteById(Math.toIntExact(id));
    }

    @Transactional
    public Tarea updateTarea(Long id, Tarea updatedTarea) {
        return tareaRepository.findById(Math.toIntExact(id)).map(tarea -> {
            tarea.setDescripcion(updatedTarea.getDescripcion());
            tarea.setAusencia(updatedTarea.getAusencia());
            tarea.setGrupo(updatedTarea.getGrupo());
            tarea.setAsignatura(updatedTarea.getAsignatura());
            return tareaRepository.save(tarea);
        }).orElse(null);
    }
}
