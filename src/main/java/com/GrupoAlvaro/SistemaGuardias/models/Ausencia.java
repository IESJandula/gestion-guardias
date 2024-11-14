package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ausencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @ElementCollection
    private List<Hora> horas; // Lista de horas afectadas

    @ManyToOne
    @JsonBackReference
    private Profesor profesorAusente;

    @OneToMany(mappedBy = "ausencia", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Tarea> tareas = new ArrayList<>(); // Inicialización de la lista

    @OneToMany(mappedBy = "ausencia")
    private List<Asignacion> asignaciones;

    @ManyToMany
    @JoinTable(
            name = "grupo_ausencia",
            joinColumns = @JoinColumn(name = "ausencia_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id")
    )
    private List<Grupo> gruposAusentes;

    public Ausencia() {}

    public Ausencia(Profesor profesorAusente, LocalDate fechaInicio, LocalDate fechaFin, List<Hora> horas) {
        this.profesorAusente = profesorAusente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horas = horas;
        this.tareas = new ArrayList<>();
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

    public void setId(Long id) {
        this.id = id;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }

    public List<Grupo> getGruposAusentes() {
        return gruposAusentes;
    }

    public void setGruposAusentes(List<Grupo> gruposAusentes) {
        this.gruposAusentes = gruposAusentes;
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


