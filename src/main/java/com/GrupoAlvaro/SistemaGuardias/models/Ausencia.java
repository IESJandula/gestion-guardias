package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Ausencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ElementCollection
    private List<Integer> horas; // Lista de horas afectadas

    @ManyToOne
    private Profesor profesorAusente;

    @OneToMany(mappedBy = "ausencia")
    private List<Tarea> tareas;

    @OneToMany(mappedBy = "ausencia")
    private List<Asignacion> asignaciones;


    public Ausencia() {}


    public Ausencia(Profesor profesorAusente, LocalDate fechaInicio, LocalDate fechaFin) {
        this.profesorAusente = profesorAusente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }


    public Long getId() {
        return id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Integer> getHoras() {
        return horas;
    }

    public void setHoras(List<Integer> horas) {
        this.horas = horas;
    }

    public Profesor getProfesorAusente() {
        return profesorAusente;
    }

    public void setProfesorAusente(Profesor profesorAusente) {
        this.profesorAusente = profesorAusente;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
}


