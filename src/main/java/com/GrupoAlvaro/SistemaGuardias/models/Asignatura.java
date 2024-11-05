package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abreviatura;
    private String nombre;
    private String nivel;
    private String curso;

    @OneToMany(mappedBy = "asignatura")
    private List<Horario> horarios;

    public Asignatura() {}

    public Asignatura(String abreviatura, String nombre, String nivel, String curso) {
        this.abreviatura = abreviatura;
        this.nombre = nombre;
        this.nivel = nivel;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }
}
