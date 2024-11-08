package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import com.GrupoAlvaro.SistemaGuardias.repositories.NotificacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    @Autowired
    public NotificacionService(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    public Optional<Notificacion> findById(Long id) {
        return notificacionRepository.findById(id);
    }

    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public void deleteById(Long id) {
        notificacionRepository.deleteById(id);
    }

    public Notificacion updateNotificacion(Long id, Notificacion updatedNotificacion) {
        return notificacionRepository.findById(id).map(notificacion -> {
            notificacion.setMensaje(updatedNotificacion.getMensaje());
            notificacion.setFechaHora(updatedNotificacion.getFechaHora());
            notificacion.setJustificanteMedico(updatedNotificacion.getJustificanteMedico());
            return notificacionRepository.save(notificacion);
        }).orElse(null);
    }
}
