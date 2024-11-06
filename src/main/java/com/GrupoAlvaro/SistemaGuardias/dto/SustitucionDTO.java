package com.GrupoAlvaro.SistemaGuardias.dto;

public class SustitucionDTO {

    private Long id;
    private String profesorGuardiaNombre;
    private String grupoNombre;
    private String aulaNombre;
    private Boolean realizado;


    public SustitucionDTO() {}


    public SustitucionDTO(Long id, String profesorGuardiaNombre, String grupoNombre, String aulaNombre, Boolean realizado) {
        this.id = id;
        this.profesorGuardiaNombre = profesorGuardiaNombre;
        this.grupoNombre = grupoNombre;
        this.aulaNombre = aulaNombre;
        this.realizado = realizado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }


    public String getProfesorGuardiaNombre() {
        return profesorGuardiaNombre;
    }

    public void setProfesorGuardiaNombre(String profesorGuardiaNombre) {
        this.profesorGuardiaNombre = profesorGuardiaNombre;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public String getAulaNombre() {
        return aulaNombre;
    }

    public void setAulaNombre(String aulaNombre) {
        this.aulaNombre = aulaNombre;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
}

