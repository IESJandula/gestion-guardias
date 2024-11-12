package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import com.GrupoAlvaro.SistemaGuardias.repositories.NotificacionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacionService {

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Transactional
    public Notificacion guardarNotificacion(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public List<Notificacion> listarNotificaciones() {
        return notificacionRepository.findAll();
    }

    @Transactional
    public Notificacion buscarNotificacionPorId(Long id) {
        Optional<Notificacion> notificacion = notificacionRepository.findById(id);
        if (notificacion.isPresent()) {
            return notificacion.get();
        }else {
            throw new ResourceNotFoundException("No se encontro el notificacion con el id " + id);
        }
    }

    @Transactional
    public void eliminarNotificacion(Long id) {
        Notificacion notificacion = buscarNotificacionPorId(id);
        notificacionRepository.delete(notificacion);
    }

    @Transactional
    public Notificacion actualizarNotificacion(Long id, Notificacion notificacionNueva) {
        Notificacion notificacion = buscarNotificacionPorId(id);
        notificacion.setFechaHora(notificacionNueva.getFechaHora());
        notificacion.setMensaje(notificacionNueva.getMensaje());
        return notificacionRepository.save(notificacion);
    }


}
