package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class AsignaturaDTO {

    private Long id;
    private String nombre;
    private List<Long> gruposIds;
    private List<Long> profesoresIds;
    private List<Long> clasesIds;
    private List<Long> tareasIds;

    public AsignaturaDTO() {}

    public AsignaturaDTO(Long id, String nombre, List<Long> gruposIds, List<Long> profesoresIds, List<Long> clasesIds, List<Long> tareasIds) {
        this.id = id;
        this.nombre = nombre;
        this.gruposIds = gruposIds;
        this.profesoresIds = profesoresIds;
        this.clasesIds = clasesIds;
        this.tareasIds = tareasIds;
    }

    // Getters y Setters
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

    public List<Long> getProfesoresIds() {
        return profesoresIds;
    }

    public void setProfesoresIds(List<Long> profesoresIds) {
        this.profesoresIds = profesoresIds;
    }

    public List<Long> getClasesIds() {
        return clasesIds;
    }

    public void setClasesIds(List<Long> clasesIds) {
        this.clasesIds = clasesIds;
    }

    public List<Long> getTareasIds() {
        return tareasIds;
    }

    public void setTareasIds(List<Long> tareasIds) {
        this.tareasIds = tareasIds;
    }
}
