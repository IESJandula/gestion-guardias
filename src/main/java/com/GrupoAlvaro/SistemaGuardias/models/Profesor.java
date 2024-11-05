package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesor")
    private List<Guardia> guardias;

    @OneToMany(mappedBy = "profesor")
    private List<Ausencia> ausencias;

    public Profesor() {}

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ausencia> getAusencias() {
        return ausencias;
    }

    public void setAusencias(List<Ausencia> ausencias) {
        this.ausencias = ausencias;
    }

    public List<Guardia> getGuardias() {
        return guardias;
    }

    public void setGuardias(List<Guardia> guardias) {
        this.guardias = guardias;
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
