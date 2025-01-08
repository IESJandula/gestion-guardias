package com.FranGarcia.NuevaVersionGuardias.controllers;

import com.FranGarcia.NuevaVersionGuardias.models.Cobertura;
import com.FranGarcia.NuevaVersionGuardias.services.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

