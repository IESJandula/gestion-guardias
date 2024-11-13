package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.dto.DetalleAusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.services.AusenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
}


