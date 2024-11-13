package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.AsignaturaDTO;
import com.GrupoAlvaro.SistemaGuardias.dto.RespuestaDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.services.AsignaturaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asignatura")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @PostMapping("/registrar")
    public ResponseEntity<RespuestaDTO> registrarAsignatura(@RequestBody AsignaturaDTO asignaturaDTO) {
        try {
            AsignaturaDTO asignaturaGuardada = asignaturaService.guardarAsignatura(asignaturaDTO);
            RespuestaDTO respuesta = new RespuestaDTO("asignatura registrada correctamente", HttpStatus.OK.value());
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);
        } catch (Exception e){
            RespuestaDTO respuesta = new RespuestaDTO("Error al registrar asignatura: "  + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
        }
    }
}
