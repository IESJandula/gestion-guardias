package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.NotificacionDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.NotificacionRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private ProfesorRepository profesorRepository; // Para obtener el profesor por ID

    @Transactional
    public Notificacion crearNotificacion(NotificacionDTO notificacionDTO) {
        Profesor profesor = profesorRepository.findById(notificacionDTO.getProfesorId())
                .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado"));

        Notificacion notificacion = new Notificacion();
        notificacion.setMensaje(notificacionDTO.getMensaje());
        notificacion.setJustificanteMedico(notificacionDTO.getJustificanteMedico());
        notificacion.setProfesor(profesor);
        notificacion.setFechaHora(LocalDateTime.now());

        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> listarNotificaciones() {
        return notificacionRepository.findAll();
    }

    public List<Notificacion> listarNotificacionesPorProfesor(Long profesorId) {
        return notificacionRepository.findByProfesorId(profesorId);
    }

    @Transactional
    public Notificacion actualizarNotificacion(Long id, NotificacionDTO notificacionDTO) {
        Notificacion notificacion = notificacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Notificación no encontrada"));

        Profesor profesor = profesorRepository.findById(notificacionDTO.getProfesorId())
                .orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado"));

        notificacion.setMensaje(notificacionDTO.getMensaje());
        notificacion.setJustificanteMedico(notificacionDTO.getJustificanteMedico());
        notificacion.setProfesor(profesor);

        return notificacionRepository.save(notificacion);
    }

    @Transactional
    public void eliminarNotificacion(Long id) {
        notificacionRepository.deleteById(id);
    }
}


