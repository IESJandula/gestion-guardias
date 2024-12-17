package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.services.AusenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ausencias")
public class AusenciaController {

    @Autowired
    private AusenciaService ausenciaService;

    // Registrar una ausencia
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarAusencia(@Valid @RequestBody AusenciaDTO ausenciaDTO) {
        try {
            // Llamar al servicio para registrar la ausencia
            ausenciaService.registrarAusencia(ausenciaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Ausencia registrada exitosamente");
        } catch (ResourceNotFoundException e) {
            // Si no se encuentra el profesor, devolver un error 404
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (RuntimeException e) {
            // Manejo de errores generales con un 400 si hay datos incorrectos
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error de validación: " + e.getMessage());
        } catch (Exception e) {
            // Error general que no se ha manejado
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado");
        }
    }

    // Listar todas las ausencias
    @GetMapping("/listar")
    public ResponseEntity<List<Ausencia>> listarAusencias() {
        List<Ausencia> ausencias = ausenciaService.listarAusencias();
        return ResponseEntity.ok(ausencias);
    }

    @GetMapping("/listar/{fecha}")
    public ResponseEntity<List<Ausencia>> listarAusenciasByFecha(@PathVariable String fecha) {
        LocalDate fechaEnLocalDate = LocalDate.parse(fecha);
        List<Ausencia> ausenciasDelDia = ausenciaService.listarAusenciasPorFecha(fechaEnLocalDate);
        return ResponseEntity.ok(ausenciasDelDia);
    }

    // Obtener ausencias por profesor
    @GetMapping("/profesor/{email}")
    public ResponseEntity<List<Ausencia>> listarAusenciasPorProfesor(@PathVariable String email) {
        List<Ausencia> ausencias = ausenciaService.listarAusenciasPorProfesor(email);
        return ResponseEntity.ok(ausencias);
    }

    // Actualizar una ausencia
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarAusencia(@PathVariable Long id,@Valid @RequestBody AusenciaDTO ausenciaDTO) {
        try {
            ausenciaService.actualizarAusencia(id, ausenciaDTO);
            return ResponseEntity.ok("Ausencia actualizada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar la ausencia");
        }
    }

    // Eliminar una ausencia
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAusencia(@PathVariable Long id) {
        try {
            ausenciaService.eliminarAusencia(id);
            return ResponseEntity.ok("Ausencia eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la ausencia");
        }
    }
}


