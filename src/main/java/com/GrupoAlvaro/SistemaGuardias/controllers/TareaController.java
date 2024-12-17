package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.dto.DetalleAusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.*;
import com.GrupoAlvaro.SistemaGuardias.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @Autowired
    private AusenciaService ausenciaService;

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private GrupoService grupoService;

    @Autowired
    private AsignaturaService asignaturaService;

    // Endpoint para registrar una ausencia y crear tareas asociadas
    @PostMapping("/registrar-para-ausencia")
    public ResponseEntity<String> registrarTareasParaAusencia(@RequestBody AusenciaDTO ausenciaDTO) {
        // Obtener el profesor
        Profesor profesor = profesorService.obtenerProfesor(ausenciaDTO.getProfesorEmail())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        // Crear la ausencia
        Ausencia ausencia = new Ausencia(profesor, ausenciaDTO.getFecha(), ausenciaDTO.getHoras());
        ausenciaService.registrarAusencia(ausenciaDTO);

        // Crear tareas basadas en los detalles
        for (DetalleAusenciaDTO detalle : ausenciaDTO.getDetalles()) {
            // Obtener el grupo y la asignatura
            Grupo grupo = grupoService.obtenerGrupo(detalle.getGrupoNombre())
                    .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));
            Asignatura asignatura = asignaturaService.obtenerAsignatura(detalle.getAsignaturaId())
                    .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

            // Crear la tarea
            Tarea tarea = new Tarea();
            tarea.setDescripcion(detalle.getTarea());
            tarea.setAusencia(ausencia);
            tarea.setGrupo(grupo);
            tarea.setAsignatura(asignatura);

            // Asociar la tarea con la hora y fecha
            tarea.setHora(detalle.getHora());

            // Guardar la tarea
            tareaService.guardarTarea(tarea);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("Ausencia registrada y tareas asignadas correctamente");
    }
}

