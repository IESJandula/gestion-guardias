package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.GrupoDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;
import com.GrupoAlvaro.SistemaGuardias.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@RestController
@RequestMapping("/grupos")
public class GrupoController {
    @Autowired
    GrupoService grupoService;

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarGrupo(@RequestBody GrupoDTO grupo){
        try {
            grupoService.crearGrupo(grupo);
            return ResponseEntity.ok("Grupo registrado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar la ausencia");
        }
    }
}
