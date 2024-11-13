package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class GrupoDTO {

    private Long id;
    private String nombre;
    private boolean esConflictivo;

    public GrupoDTO() {}

    public GrupoDTO(Long id, String nombre, boolean esConflictivo) {
        this.id = id;
        this.nombre = nombre;
        this.esConflictivo = esConflictivo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isEsConflictivo() {
        return esConflictivo;
    }

    public void setEsConflictivo(boolean esConflictivo) {
        this.esConflictivo = esConflictivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
