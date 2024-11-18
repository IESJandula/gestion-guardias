package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.GrupoDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;
import com.GrupoAlvaro.SistemaGuardias.services.GrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // Listar todos los grupos
    @GetMapping("/listar")
    public ResponseEntity<List<Grupo>> listarGrupos() {
        List<Grupo> grupos = grupoService.listarGrupos();
        return ResponseEntity.ok(grupos);
    }

    // Obtener un grupo por nombre
    @GetMapping("/{nombre}")
    public ResponseEntity<Grupo> obtenerGrupo(@PathVariable String nombre) {
        Optional<Grupo> grupo = grupoService.obtenerGrupo(nombre);
        return grupo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Actualizar un grupo
    @PutMapping("/actualizar/{nombre}")
    public ResponseEntity<String> actualizarGrupo(@PathVariable String nombre, @RequestBody GrupoDTO grupoDTO) {
        try {
            grupoService.actualizarGrupo(nombre, grupoDTO);
            return ResponseEntity.ok("Grupo actualizado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el grupo");
        }
    }

    // Eliminar un grupo
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarGrupo(@PathVariable Long id) {
        try {
            grupoService.eliminarGrupo(id);
            return ResponseEntity.ok("Grupo eliminado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar el grupo");
        }
    }
}
