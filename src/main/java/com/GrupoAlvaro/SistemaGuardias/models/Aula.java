package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String abreviatura;
    private String nombre;

    @OneToMany(mappedBy = "aula")
    private List<Horario> horarios;

    @ManyToOne
    @JoinColumn(name = "grupo_id")
    private Grupo grupo;


    //constructor vacio
    public Aula() {}

    public long getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
