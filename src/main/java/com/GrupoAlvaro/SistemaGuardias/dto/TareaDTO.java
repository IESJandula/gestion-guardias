package com.GrupoAlvaro.SistemaGuardias.dto;

import java.time.LocalDate;

public class TareaDTO {

    private Long profesorId;
    private String descripcion;
    private LocalDate fechaLimite;

    // Getters y setters
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
}


