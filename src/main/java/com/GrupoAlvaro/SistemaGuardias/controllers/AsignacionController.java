package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignacionDTO;
import com.GrupoAlvaro.SistemaGuardias.dto.RespuestaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Asignacion;
import com.GrupoAlvaro.SistemaGuardias.services.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    // Registrar una asignación
    @PostMapping("/registrar")
    public ResponseEntity<RespuestaDTO> registrarAsignacion(@RequestBody AsignacionDTO asignacionDTO) {
        try {
            AsignacionDTO asignacionGuardada = asignacionService.guardarAsignacion(asignacionDTO);
            // Se devuelve la asignación guardada con el mensaje de éxito
            RespuestaDTO respuesta = new RespuestaDTO("Asignación registrada exitosamente", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);
        } catch (Exception e) {
            // Mejor manejo del error incluyendo detalles de la excepción
            RespuestaDTO respuesta = new RespuestaDTO("Error al registrar la asignación: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }

    // Mostrar asignaciones por fecha
    @GetMapping("/mostrar/{fecha}")
    public ResponseEntity<List<Asignacion>> mostrarAsignaciones(@PathVariable LocalDate fecha) {
        try {
            List<Asignacion> asignaciones = asignacionService.listarAsignaciones(fecha);
            if (asignaciones.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(asignaciones); // No es necesario enviar 'null'
            }
            return ResponseEntity.ok(asignaciones);
        } catch (Exception e) {
            // Mejor manejo del error con el mensaje de excepción
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}


