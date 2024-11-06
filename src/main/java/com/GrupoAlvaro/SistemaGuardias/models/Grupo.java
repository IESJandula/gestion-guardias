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

    private boolean esConflictivo;

    @OneToMany(mappedBy = "grupo")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "grupo")
    private List<Aula> aulas;

    @OneToMany(mappedBy = "grupo")
    private List<Sustitucion> sustituciones;

    public Grupo() {}

    public Grupo(String nombre, String abreviatura, String nivel, boolean esConflictivo) {
        this.nombre = nombre;
        this.esConflictivo = esConflictivo;
        this.abreviatura = abreviatura;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
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

    public boolean isEsConflictivo() {
        return esConflictivo;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Sustitucion> getSustituciones() {
        return sustituciones;
    }

    public void setSustituciones(List<Sustitucion> sustituciones) {
        this.sustituciones = sustituciones;
    }

    public boolean getEsConflictivo() {
        return esConflictivo;
    }

    public void setEsConflictivo(boolean esConflictivo) {
        this.esConflictivo = esConflictivo;
    }
}
