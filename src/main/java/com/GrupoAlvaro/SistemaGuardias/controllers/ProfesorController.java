package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.ProfesorDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.services.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    // Crear Profesor
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarProfesor(@Valid @RequestBody ProfesorDTO profesorDTO) {
        try {
            profesorService.guardarProfesor(profesorDTO);
            return ResponseEntity.ok("Profesor registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el profesor");
        }
    }

    // Listar todos los profesores
    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesores() {
        List<Profesor> profesores = profesorService.listarProfesores();
        return ResponseEntity.ok(profesores);
    }

    // Buscar profesor por email
    @GetMapping("/mostrar/{email}")
    public ResponseEntity<Profesor> obtenerProfesor(@PathVariable String email) {
        Optional<Profesor> profesor = profesorService.obtenerProfesor(email);
        return profesor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Actualizar un profesor
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarProfesor(@PathVariable Long id,@Valid @RequestBody ProfesorDTO profesorDTO) {
        try {
            profesorService.actualizarProfesor(id, profesorDTO);
            return ResponseEntity.ok("Profesor actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el profesor");
        }
    }

    // Eliminar un profesor
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProfesor(@PathVariable Long id) {
        try {
            profesorService.eliminarProfesor(id);
            return ResponseEntity.ok("Profesor eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el profesor");
        }
    }
}
