package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Grupo {

    @Id
    private String nombre;

    private boolean esConflictivo;

    public Grupo() {}

    public Grupo(String nombre, boolean esConflictivo) {
        this.nombre = nombre;
        this.esConflictivo = esConflictivo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean getEsConflictivo() {
        return esConflictivo;
    }

    public void setEsConflictivo(boolean esConflictivo) {
        this.esConflictivo = esConflictivo;
    }
}
