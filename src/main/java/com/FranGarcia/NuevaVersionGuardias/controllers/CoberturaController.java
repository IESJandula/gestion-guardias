package com.FranGarcia.NuevaVersionGuardias.controllers;

import com.FranGarcia.NuevaVersionGuardias.models.Cobertura;
import com.FranGarcia.NuevaVersionGuardias.services.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/coberturas")
public class CoberturaController {

    @Autowired
    private CoberturaService coberturaService;

    @GetMapping("/mostrarCoberturas/{dia}")
    public ResponseEntity<List<Cobertura>> mostrarCoberturas(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dia) {

        List<Cobertura> coberturas = coberturaService.obtenerCoberturasPorFecha(dia);

        if (coberturas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(coberturas);
    }

    @PostMapping("/asignarCobertura")
    public ResponseEntity<Cobertura> asignarCobertura(@RequestParam Long ausenciaId, @RequestParam String profesorEmail) {
        try {
            Cobertura cobertura = coberturaService.asignarCobertura(ausenciaId, profesorEmail);
            return ResponseEntity.ok(cobertura);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

}

