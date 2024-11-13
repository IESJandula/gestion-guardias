package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import jakarta.persistence.*;

@Entity
public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private DiaSemana diaSemana;
    private Hora hora;

    @ManyToOne
    private Profesor profesor;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Asignatura asignatura;

    @OneToOne
    private Horario horario;

    public Clase(Long id, DiaSemana diaSemana, Hora hora, Profesor profesor, Asignatura asignatura, Grupo grupo, Horario horario) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.horario = horario;
    }

    public Clase() {}

    public Long getId() {return id;}
    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
