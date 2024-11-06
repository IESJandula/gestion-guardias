package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;



@Entity
public class Horario {

    @EmbeddedId
    private HorarioId id;

    private String nombre; // Nombre de la materia o actividad para esa hora


    // Constructor vacío requerido por JPA
    protected Horario() {}

    // Constructor con todos los atributos
    public Horario(HorarioId id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters

    public HorarioId getId() {
        return id;
    }

    public void setId(HorarioId id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
