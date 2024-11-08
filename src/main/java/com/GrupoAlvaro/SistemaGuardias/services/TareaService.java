package com.GrupoAlvaro.SistemaGuardias.services;

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
        return tareaRepository.findById(id);
    }

    public Tarea save(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public void deleteById(Long id) {
        tareaRepository.deleteById(id);
    }

    public Tarea updateTarea(Long id, Tarea updatedTarea) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setDescripcion(updatedTarea.getDescripcion());
            tarea.setAusencia(updatedTarea.getAusencia());
            tarea.setGrupo(updatedTarea.getGrupo());
            tarea.setAsignatura(updatedTarea.getAsignatura());
            return tareaRepository.save(tarea);
        }).orElse(null);
    }
}
