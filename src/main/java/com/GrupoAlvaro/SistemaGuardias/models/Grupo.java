package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;  // Ejemplo: "1A", "2B"

    private String esConflictivo;

    @ManyToMany
    @JoinTable(
            name = "grupo_asignatura",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")
    )
    private List<Asignatura> asignaturas;

    @OneToMany(mappedBy = "grupo")
    private List<Clase> clases;

    @OneToMany(mappedBy = "grupo")
    private List<Tarea> tareas;

    @ManyToMany(mappedBy = "gruposAusentes")
    private List<Ausencia> ausencias;


    public Grupo() {}

    public Grupo(String nombre, String esConflictivo) {
        this.nombre = nombre;
        this.esConflictivo = esConflictivo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEsConflictivo() {
        return esConflictivo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String isEsConflictivo() {
        return esConflictivo;
    }

    public void setEsConflictivo(String esConflictivo) {
        this.esConflictivo = esConflictivo;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public List<Ausencia> getAusencias() {
        return ausencias;
    }

    public void setAusencias(List<Ausencia> ausencias) {
        this.ausencias = ausencias;
    }
}
