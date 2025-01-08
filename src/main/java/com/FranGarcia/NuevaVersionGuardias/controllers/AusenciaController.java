package com.FranGarcia.NuevaVersionGuardias.controllers;

import com.FranGarcia.NuevaVersionGuardias.dto.AusenciaDTO;
import com.FranGarcia.NuevaVersionGuardias.models.Ausencia;
import com.FranGarcia.NuevaVersionGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ausencias")
public class AusenciaController {

    @Autowired
    private AusenciaService ausenciaService;

    @PostMapping("/registrar")
    public ResponseEntity<Ausencia> registrarAusencia(@RequestBody AusenciaDTO ausenciaDTO) {
        try {
            // Llamamos al servicio para registrar la ausencia
            Ausencia ausencia = ausenciaService.registrarAusencia(ausenciaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(ausencia);
        } catch (Exception e) {
            // Si ocurre un error, devolvemos una respuesta de error
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}

