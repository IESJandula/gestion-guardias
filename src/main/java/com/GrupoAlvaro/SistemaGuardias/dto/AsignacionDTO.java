package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import com.GrupoAlvaro.SistemaGuardias.enums.TipoAsignacion;

public class AsignacionDTO {

    private String profesorId;
    private Long tareaId;
    private Long guardiaId;
    private TipoAsignacion tipoAsignacion; // "Guardia", "Clase", etc.
    private DiaSemana diaSemana; // Lunes, Martes, etc.
    private Hora hora; // Hora de la asignación
    private Long aulaId; // ID del aula asignada

    public AsignacionDTO(String profesorId, Long tareaId, Long guardiaId, TipoAsignacion tipoAsignacion, DiaSemana diaSemana, Hora hora, Long aulaId) {
        this.profesorId = profesorId;
        this.tareaId = tareaId;
        this.guardiaId = guardiaId;
        this.tipoAsignacion = tipoAsignacion;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.aulaId = aulaId;
    }
    public AsignacionDTO() {}

    // Getters y setters
    public String getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(String profesorId) {
        this.profesorId = profesorId;
    }

    public Long getTareaId() {
        return tareaId;
    }

    public void setTareaId(Long tareaId) {
        this.tareaId = tareaId;
    }

    public Long getGuardiaId() {
        return guardiaId;
    }

    public void setGuardiaId(Long guardiaId) {
        this.guardiaId = guardiaId;
    }

    public TipoAsignacion getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }
}

