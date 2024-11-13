package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

@Entity
public class Guardia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diaSemana;
    private int hora;

    @ManyToOne
    private Profesor profesor;

    @OneToOne
    private Horario horario;

    @OneToOne(mappedBy = "guardia")
    private Asignacion asignacion;

    public Guardia(Long id, String diaSemana, Profesor profesor, int hora, Horario horario, Asignacion asignacion) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.profesor = profesor;
        this.hora = hora;
        this.horario = horario;
        this.asignacion = asignacion;
    }

    public Guardia() {}

    public Long getId() {
        return id;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }
}
