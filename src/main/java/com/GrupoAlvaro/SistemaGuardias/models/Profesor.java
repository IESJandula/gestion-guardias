package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {
    @Id
    private String email;

    private String nombre;

    //Relacion unidireccional con horario
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesorAusente")
    private List<Ausencia> ausencias;

    @OneToMany(mappedBy = "profesor")
    private List<Asignacion> asignacionesGuardia;

    @ManyToMany
    @JoinTable(
            name = "profesor_asignatura",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    private List<Asignatura> asignaturas;

    private Long contadorSustituciones;


    public Profesor() {}

    public Profesor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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
