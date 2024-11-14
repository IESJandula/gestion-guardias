package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;

public class DetalleAusenciaDTO {

    private Long grupoId;
    private String grupoNombre;
    private Long asignaturaId;
    private String asignaturaNombre;
    private String tarea;
    private Hora hora;

    // Constructor y Getters/Setters
    public DetalleAusenciaDTO(Long grupoId, String grupoNombre, Long asignaturaId, String asignaturaNombre, String tarea, Hora hora) {
        this.grupoId = grupoId;
        this.grupoNombre = grupoNombre;
        this.asignaturaId = asignaturaId;
        this.asignaturaNombre = asignaturaNombre;
        this.tarea = tarea;
        this.hora = hora;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public String getAsignaturaNombre() {
        return asignaturaNombre;
    }

    public void setAsignaturaNombre(String asignaturaNombre) {
        this.asignaturaNombre = asignaturaNombre;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}


