package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Tarea;
import com.GrupoAlvaro.SistemaGuardias.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Transactional
    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public Tarea buscarTareaPorId(Long id) {
        return tareaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));
    }

    @Transactional
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    @Transactional
    public Optional<Tarea> actualizarTarea(Long id, Tarea tareaModificada) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isPresent()) {
            tarea.get().setDescripcion(tareaModificada.getDescripcion());
        }else {
            throw new ResourceNotFoundException("Tarea no encontrada");
        }
        return tarea;
    }




}
