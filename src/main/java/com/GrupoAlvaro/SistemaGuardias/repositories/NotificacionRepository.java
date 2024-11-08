package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class NotificacionRepository extends JpaRepository<Notificacion, Long> {
    public NotificacionRepository() {
    }
    public NotificacionRepository(EntityManager em) {}
}
