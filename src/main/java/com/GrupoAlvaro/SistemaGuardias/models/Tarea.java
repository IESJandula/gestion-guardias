package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    @Enumerated(EnumType.STRING)
    private Hora hora;

    @ManyToOne
    @JsonBackReference
    private Ausencia ausencia;

    @ManyToOne
    @JsonBackReference
    private Grupo grupo;

    @ManyToOne
    @JsonBackReference
    private Asignatura asignatura;

    public Tarea(Long id, String descripcion, Hora hora, Ausencia ausencia, Grupo grupo, Asignatura asignatura) {
        this.id = id;
        this.descripcion = descripcion;
        this.hora = hora;
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

    public Hora getHora() {
        return hora;
    }
    public void setHora(Hora hora) {
        this.hora = hora;
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
