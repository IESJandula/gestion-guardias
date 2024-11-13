package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class GrupoDTO {

    private Long id;
    private String nombre;
    private boolean esConflictivo;
    private List<Long> asignaturasIds;
    private List<Long> clasesIds;
    private List<Long> tareasIds;
    private List<Long> ausenciasIds;

    public GrupoDTO() {}

    public GrupoDTO(Long id, String nombre, boolean esConflictivo, List<Long> asignaturasIds, List<Long> clasesIds, List<Long> tareasIds, List<Long> ausenciasIds) {
        this.id = id;
        this.nombre = nombre;
        this.esConflictivo = esConflictivo;
        this.asignaturasIds = asignaturasIds;
        this.clasesIds = clasesIds;
        this.tareasIds = tareasIds;
        this.ausenciasIds = ausenciasIds;
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

    public boolean isEsConflictivo() {
        return esConflictivo;
    }

    public void setEsConflictivo(boolean esConflictivo) {
        this.esConflictivo = esConflictivo;
    }

    public List<Long> getAsignaturasIds() {
        return asignaturasIds;
    }

    public void setAsignaturasIds(List<Long> asignaturasIds) {
        this.asignaturasIds = asignaturasIds;
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

    public List<Long> getAusenciasIds() {
        return ausenciasIds;
    }

    public void setAusenciasIds(List<Long> ausenciasIds) {
        this.ausenciasIds = ausenciasIds;
    }
}
