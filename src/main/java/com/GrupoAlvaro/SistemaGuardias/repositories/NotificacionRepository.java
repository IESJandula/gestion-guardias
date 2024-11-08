package com.GrupoAlvaro.SistemaGuardias.repositories;

import com.GrupoAlvaro.SistemaGuardias.models.Notificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {
    public Notificacion findByNombre(String nombre);
    public Optional<Notificacion> findById(Long id);
    public List<Notificacion> findByUsuario(Long id);
    public List<Notificacion> findByGrupo(Long id);
}
