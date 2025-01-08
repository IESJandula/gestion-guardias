package com.FranGarcia.NuevaVersionGuardias.models;

import com.FranGarcia.NuevaVersionGuardias.enums.Actividad;
import com.FranGarcia.NuevaVersionGuardias.enums.DiaSemana;
import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import jakarta.persistence.*;

@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profesor_email", nullable = false)
    private Profesor profesor;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Enumerated(EnumType.STRING)
    private HoraDia horaDia;

    @Enumerated(EnumType.STRING)
    private Actividad actividad;

    private String aulaNombre;

    public Horario() {}

    public Horario(Profesor profesor, DiaSemana diaSemana, HoraDia horaDia, Actividad actividad, String aulaNombre) {
        this.profesor = profesor;
        this.diaSemana = diaSemana;
        this.horaDia = horaDia;
        this.actividad = actividad;
        this.aulaNombre = aulaNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public HoraDia getHoraDia() {
        return horaDia;
    }

    public void setHoraDia(HoraDia horaDia) {
        this.horaDia = horaDia;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getAulaNombre() {
        return aulaNombre;
    }

    public void setAulaNombre(String aulaNombre) {
        this.aulaNombre = aulaNombre;
    }
}




