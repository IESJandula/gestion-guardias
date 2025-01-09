package com.FranGarcia.NuevaVersionGuardias.controllers;

import com.FranGarcia.NuevaVersionGuardias.dto.AusenciaDTO;
import com.FranGarcia.NuevaVersionGuardias.models.Ausencia;
import com.FranGarcia.NuevaVersionGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ausencias")
@CrossOrigin(origins = "http://127.0.0.1:5501")
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

    @GetMapping("/listar/{fecha}")
    public ResponseEntity<Map<String, List<AusenciaDTO>>> listarAusenciasPorFecha(@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        try {
            Map<String, List<AusenciaDTO>> ausenciasPorHora = ausenciaService.listarAusenciasPorFechaAgrupadasPorHora(fecha);
            if (ausenciasPorHora.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);     //Si esta vacio, querra decir que no hay ausencias ese dia, por lo que devolvera vacio
            }
            return ResponseEntity.ok(ausenciasPorHora);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}

