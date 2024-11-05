package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Grupo {

    @Id
    private String nombre;

    private String abreviatura;
    private String nivel;
    private String curso;

    @OneToMany(mappedBy = "grupo")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "grupo")
    private List<Aula> aulas;

    @OneToMany(mappedBy = "grupo")
    private List<Sustitucion> sustituciones;

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
