package com.FranGarcia.NuevaVersionGuardias.controllers;

import com.FranGarcia.NuevaVersionGuardias.dto.AusenciaDTO;
import com.FranGarcia.NuevaVersionGuardias.models.Ausencia;
import com.FranGarcia.NuevaVersionGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ausencias")
public class AusenciaController {

    @Autowired
    private AusenciaService ausenciaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarAusencias(@RequestBody List<AusenciaDTO> ausenciasDTO) {
        try {
            List<Ausencia> ausencias = new ArrayList<>();
            for (AusenciaDTO ausenciaDTO : ausenciasDTO) {
                Ausencia ausencia = ausenciaService.registrarAusencia(ausenciaDTO);
                ausencias.add(ausencia);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(ausencias);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al registrar las ausencias: " + e.getMessage());
        }
    }

}

