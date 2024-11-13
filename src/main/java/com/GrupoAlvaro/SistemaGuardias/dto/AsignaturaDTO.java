package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class AsignaturaDTO {

    private Long id;
    private String nombre;

    public AsignaturaDTO() {}

    public AsignaturaDTO(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
