package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.services.ProfesorService;
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

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarProfesor(@RequestBody Profesor profesor) {
        try {
            profesorService.guardarProfesor(profesor);
            return ResponseEntity.ok("Profesor registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar el profesor");
        }
    }

    @GetMapping("/mostrar/{email}")
    public ResponseEntity<Profesor> mostrarProfesores(@PathVariable String email) {
        try {
            Optional<Profesor> profesores = profesorService.listarProfesores(email);
            if (profesores.isPresent()) {
                return ResponseEntity.ok(profesores.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
