package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String apellido;
    private Integer contadorGuardias;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesor")
    private List<Sustitucion> sustituciones;

    public Profesor() {}

    public Profesor(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public long getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getContadorGuardias() {
        return contadorGuardias;
    }

    public void setContadorGuardias(Integer contadorGuardias) {
        this.contadorGuardias = contadorGuardias;
    }

    public List<Sustitucion> getSustituciones() {
        return sustituciones;
    }

    public void setSustituciones(List<Sustitucion> sustituciones) {
        this.sustituciones = sustituciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }
}
