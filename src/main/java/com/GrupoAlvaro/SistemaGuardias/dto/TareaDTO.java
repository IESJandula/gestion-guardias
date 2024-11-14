package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;

import java.time.LocalDate;

public class TareaDTO {

    private Long profesorId;
    private String descripcion;
    private LocalDate fechaLimite;
    private Long grupoId;
    private Long asignaturaId;
    private Hora hora;

    // Constructor
    public TareaDTO(Long profesorId, String descripcion, LocalDate fechaLimite, Long grupoId, Long asignaturaId, Hora hora) {
        this.profesorId = profesorId;
        this.descripcion = descripcion;
        this.fechaLimite = fechaLimite;
        this.grupoId = grupoId;
        this.asignaturaId = asignaturaId;
        this.hora = hora;
    }

    // Getters y Setters
    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public Long getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Long grupoId) {
        this.grupoId = grupoId;
    }

    public Long getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(Long asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}



