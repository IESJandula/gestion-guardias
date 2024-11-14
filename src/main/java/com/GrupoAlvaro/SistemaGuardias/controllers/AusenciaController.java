package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ausencias")
public class AusenciaController {

    @Autowired
    private AusenciaService ausenciaService;

    // Registrar una ausencia
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAusencia(@RequestBody AusenciaDTO ausenciaDTO) {
        try {
            ausenciaService.registrarAusencia(ausenciaDTO);
            return ResponseEntity.ok("Ausencia registrada correctamente y notificación enviada.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar la ausencia.");
        }
    }

    // Listar todas las ausencias
    @GetMapping("/listar")
    public ResponseEntity<List<Ausencia>> listarAusencias() {
        List<Ausencia> ausencias = ausenciaService.listarAusencias();
        return ResponseEntity.ok(ausencias);
    }

    // Obtener ausencias por profesor
    @GetMapping("/profesor/{email}")
    public ResponseEntity<List<Ausencia>> listarAusenciasPorProfesor(@PathVariable String email) {
        List<Ausencia> ausencias = ausenciaService.listarAusenciasPorProfesor(email);
        return ResponseEntity.ok(ausencias);
    }

    // Actualizar una ausencia
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarAusencia(@PathVariable Long id, @RequestBody AusenciaDTO ausenciaDTO) {
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


