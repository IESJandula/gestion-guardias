package com.GrupoAlvaro.SistemaGuardias.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "asignaturas")
    @JsonBackReference
    private List<Grupo> grupos;

    @ManyToMany(mappedBy = "asignaturas")
    private List<Profesor> profesores;

    @OneToMany(mappedBy = "asignatura")
    private List<Clase> clases;

    @OneToMany(mappedBy = "asignatura")
    private List<Tarea> tareas;

    public Asignatura(Long id, String nombre, List<Grupo> grupos, List<Profesor> profesores, List<Clase> clases, List<Tarea> tareas) {
        this.id = id;
        this.nombre = nombre;
        this.grupos = grupos;
        this.profesores = profesores;
        this.clases = clases;
        this.tareas = tareas;
    }
    public Asignatura() {}

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

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
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
}
