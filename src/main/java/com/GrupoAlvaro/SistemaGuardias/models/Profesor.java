package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;
    private String email;

    //Relacion unidireccional con horario
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesorAusente")
    private List<Ausencia> ausencias;

    @OneToMany(mappedBy = "profesor")
    private List<Asignacion> asignacionesGuardia;

    private Long contadorSustituciones;


    public Profesor() {}

    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

    public List<Ausencia> getAusencias() {
        return ausencias;
    }

    public void setAusencias(List<Ausencia> ausencias) {
        this.ausencias = ausencias;
    }

    public List<Asignacion> getAsignacionesGuardia() {
        return asignacionesGuardia;
    }

    public void setAsignacionesGuardia(List<Asignacion> asignacionesGuardia) {
        this.asignacionesGuardia = asignacionesGuardia;
    }

    public Long getContadorSustituciones() {
        return contadorSustituciones;
    }

    public void setContadorSustituciones(Long contadorSustituciones) {
        this.contadorSustituciones = contadorSustituciones;
    }
}
