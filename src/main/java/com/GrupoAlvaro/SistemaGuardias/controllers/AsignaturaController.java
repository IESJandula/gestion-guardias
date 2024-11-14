package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignaturaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAsignatura(@RequestBody Asignatura asignatura) {
        try {
            asignaturaService.guardarAsignatura(asignatura);
            return ResponseEntity.ok("asignatura registrada correctamente");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar asignatura");
        }
    }

    // Listar todas las asignaturas
    @GetMapping("/listar")
    public ResponseEntity<List<Asignatura>> listarAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.listarAsignaturas();
        return ResponseEntity.ok(asignaturas);
    }

    // Obtener una asignatura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignatura(@PathVariable Long id) {
        Optional<Asignatura> asignatura = asignaturaService.obtenerAsignatura(id);
        return asignatura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Actualizar una asignatura
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarAsignatura(@PathVariable Long id, @RequestBody AsignaturaDTO asignaturaDTO) {
        try {
            asignaturaService.actualizarAsignatura(id, asignaturaDTO);
            return ResponseEntity.ok("Asignatura actualizada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar asignatura");
        }
    }

    // Eliminar una asignatura
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarAsignatura(@PathVariable Long id) {
        try {
            asignaturaService.eliminarAsignatura(id);
            return ResponseEntity.ok("Asignatura eliminada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar asignatura");
        }
    }
}
