package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @ManyToOne
    private Ausencia ausencia;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Asignatura asignatura;

    public Tarea(Long id, String descripcion, Ausencia ausencia, Grupo grupo, Asignatura asignatura) {
        this.id = id;
        this.descripcion = descripcion;
        this.ausencia = ausencia;
        this.grupo = grupo;
        this.asignatura = asignatura;
    }

    public Tarea() {}

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Ausencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(Ausencia ausencia) {
        this.ausencia = ausencia;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }
}
