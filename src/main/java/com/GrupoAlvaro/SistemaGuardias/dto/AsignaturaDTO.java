package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private List<Long> gruposIds;

    public AsignaturaDTO() {}

    public AsignaturaDTO(Long id, String nombre, List<Long> gruposIds) {
        this.id = id;
        this.nombre = nombre;
        this.gruposIds = gruposIds;
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

    public List<Long> getGruposIds() {
        return gruposIds;
    }

    public void setGruposIds(List<Long> gruposIds) {
        this.gruposIds = gruposIds;
    }
}
