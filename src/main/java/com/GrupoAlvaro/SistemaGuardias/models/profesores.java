package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    //Falta generar horario de tipo jsonb


    public profesores(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    //constructor vacío
    public profesores(){
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "profesores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
