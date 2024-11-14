package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.dto.DetalleAusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.models.Tarea;
import com.GrupoAlvaro.SistemaGuardias.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AusenciaService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private AusenciaRepository ausenciaRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private TareaRepository tareaRepository;

    public Optional<Ausencia> listarAusenciaById(Long id) {
        return ausenciaRepository.findById(id);
    }


    @Transactional
    public void registrarAusencia(AusenciaDTO ausenciaDTO) {
        Profesor profesor = profesorRepository.findByEmail(ausenciaDTO.getProfesorEmail())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        // Crear y guardar la ausencia
        Ausencia ausencia = new Ausencia(profesor, ausenciaDTO.getFechaInicio(), ausenciaDTO.getFechaFin(), ausenciaDTO.getHoras());
        ausenciaRepository.save(ausencia);

        // Guardar y asociar las tareas a la ausencia
        for (DetalleAusenciaDTO detalle : ausenciaDTO.getDetalles()) {
            Tarea tarea = new Tarea();
            tarea.setDescripcion(detalle.getTarea());
            tarea.setHora(detalle.getHora());

            // Encontrar y asociar el grupo y la asignatura
            tarea.setGrupo(grupoRepository.findById(detalle.getGrupoId())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado")));
            tarea.setAsignatura(asignaturaRepository.findById(detalle.getAsignaturaId())
                    .orElseThrow(() -> new RuntimeException("Asignatura no encontrada")));

            // Asociar la tarea a la ausencia
            tarea.setAusencia(ausencia);

            // Guardar la tarea en la base de datos
            tareaRepository.save(tarea);

            // Agregar la tarea a la lista de tareas de la ausencia
            ausencia.getTareas().add(tarea); // Esta línea agrega la tarea correctamente
        }

        // Actualizar la ausencia con las tareas asociadas
        ausenciaRepository.save(ausencia);
    }


    public List<Ausencia> listarAusencias() {
        return ausenciaRepository.findAll();
    }

    public List<Ausencia> listarAusenciasPorProfesor(String email) {
        Profesor profesor = (Profesor) profesorRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        return ausenciaRepository.findByProfesorAusente(profesor);
    }

    @Transactional
    public void actualizarAusencia(Long id, AusenciaDTO ausenciaDTO) {
        Optional<Ausencia> ausenciaOpt = ausenciaRepository.findById(id);
        if (ausenciaOpt.isPresent()) {
            Ausencia ausencia = ausenciaOpt.get();
            Profesor profesor = (Profesor) profesorRepository.findByEmail(ausenciaDTO.getProfesorEmail()).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
            ausencia.setProfesorAusente(ausencia.getProfesorAusente());
            ausencia.setFechaInicio(ausenciaDTO.getFechaInicio());
            ausencia.setFechaFin(ausenciaDTO.getFechaFin());
            ausenciaRepository.save(ausencia);
        }
    }

    @Transactional
    public void eliminarAusencia(Long id) {
        ausenciaRepository.deleteById(id);
    }

}
