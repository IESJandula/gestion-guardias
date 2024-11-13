package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ausencias")
public class AusenciaController {

    @Autowired
    private AusenciaService ausenciaService;


    @PostMapping("/registrar")
    public ResponseEntity<String> registrarAusencia(@RequestBody AusenciaDTO ausenciaDTO) {
        try {
            ausenciaService.registrarAusencia(ausenciaDTO);
            return ResponseEntity.ok("Ausencia registrada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar la ausencia");
        }
    }

    @GetMapping("/mostrar/{fecha}")
    public ResponseEntity<String> mostrarAusencias(@PathVariable LocalDate fecha) {
        try {

            Optional<List<Ausencia>> ausencias = ausenciaService.buscarAusenciasByFecha(fecha);

            if (ausencias.isPresent() && !ausencias.get().isEmpty()) {
                return ResponseEntity.ok("Esta es la lista de ausencias");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron ausencias para este día");
            }

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error inesperado al procesar la solicitud");
        }
    }
}
