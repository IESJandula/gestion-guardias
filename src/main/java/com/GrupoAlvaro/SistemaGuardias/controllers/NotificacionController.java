package com.GrupoAlvaro.SistemaGuardias.controllers;

import com.GrupoAlvaro.SistemaGuardias.dto.NotificacionDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import com.GrupoAlvaro.SistemaGuardias.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionController {

    @Autowired
    private NotificacionService notificacionService;

    @PostMapping("/crear")
    public ResponseEntity<Notificacion> crearNotificacion(@RequestBody NotificacionDTO notificacionDTO) {
        Notificacion notificacion = notificacionService.crearNotificacion(notificacionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacion);
    }

    @GetMapping("/mostrar")
    public ResponseEntity<List<Notificacion>> listarNotificaciones() {
        List<Notificacion> notificaciones = notificacionService.listarNotificaciones();
        return ResponseEntity.ok(notificaciones);
    }

    @GetMapping("/profesor/{profesorId}")
    public ResponseEntity<List<Notificacion>> listarNotificacionesPorProfesor(@PathVariable Long profesorId) {
        List<Notificacion> notificaciones = notificacionService.listarNotificacionesPorProfesor(profesorId);
        return ResponseEntity.ok(notificaciones);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Notificacion> actualizarNotificacion(@PathVariable Long id, @RequestBody NotificacionDTO notificacionDTO) {
        Notificacion notificacion = notificacionService.actualizarNotificacion(id, notificacionDTO);
        return ResponseEntity.ok(notificacion);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarNotificacion(@PathVariable Long id) {
        notificacionService.eliminarNotificacion(id);
        return ResponseEntity.noContent().build();
    }
}
