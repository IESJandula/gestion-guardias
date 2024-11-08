package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    public Notificacion findByNombre(String nombre);
    public Notificacion findById(long id);
    public List<Notificacion> findByUsuario(long id);
    public List<Notificacion> findByGrupo(long id);
}
