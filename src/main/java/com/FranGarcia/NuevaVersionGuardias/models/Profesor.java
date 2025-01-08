package com.FranGarcia.NuevaVersionGuardias.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {

    @Id
    private String email; // Clave primaria

    private String nombre;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Horario> horarios = new ArrayList<>();

    @OneToMany(mappedBy = "profesorAusente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ausencia> faltas = new ArrayList<>();

    @OneToMany(mappedBy = "profesorCubre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cobertura> coberturas = new ArrayList<>();

    public Profesor() {}

    public Profesor(String email, String nombre) {
        this.email = email;
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Ausencia> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Ausencia> faltas) {
        this.faltas = faltas;
    }

    public List<Cobertura> getCoberturas() {
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
}


