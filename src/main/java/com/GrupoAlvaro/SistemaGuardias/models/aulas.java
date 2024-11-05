package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class aulas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    //Revisar no se si es int o long al ser una clave foranea de grupo
    private int grupoId;

    public aulas(long id, int grupoId, String nombre) {
        this.id = id;
        this.grupoId = grupoId;
        this.nombre = nombre;
    }

    //constructor vacio
    public aulas() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "aulas{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", grupoId=" + grupoId +
                '}';
    }
}
