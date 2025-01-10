package com.FranGarcia.NuevaVersionGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Aula {

    @Id
    private String nombre; // Ejemplo: "Aula 101", "Sala de Tecnología", etc.

    private String ubicacion;


    public Aula() {}

    public Aula(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }


}

