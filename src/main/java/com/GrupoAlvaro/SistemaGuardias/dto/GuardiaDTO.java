package com.GrupoAlvaro.SistemaGuardias.dto;

public class GuardiaDTO {

    private String tipo; // Puede ser "Sustitución", "Refuerzo", etc.
    private String horario;
    private String profesorEmail; // Email del profesor asignado
    private Long aulaId; // ID del aula

    // Getters y setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getProfesorEmail() {
        return profesorEmail;
    }

    public void setProfesorEmail(String profesorEmail) {
        this.profesorEmail = profesorEmail;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }
}

