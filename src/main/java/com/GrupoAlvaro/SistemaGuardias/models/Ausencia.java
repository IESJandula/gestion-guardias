package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ausencias")
public class Ausencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;
    private Integer horas;
    private String tareas;

    public Ausencia() {}

    public Ausencia(LocalDate fecha, String tareas, Integer horas) {
        this.fecha = fecha;
        this.tareas = tareas;
        this.horas = horas;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

}

