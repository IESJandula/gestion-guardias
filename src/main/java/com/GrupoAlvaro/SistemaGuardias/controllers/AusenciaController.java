package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.services.AusenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ausencias")
public class AusenciaController {

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
}
