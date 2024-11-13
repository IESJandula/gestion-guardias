package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import com.GrupoAlvaro.SistemaGuardias.enums.TipoActividad;
import jakarta.persistence.*;

@Entity
public class Horario {

    @Id
    private Long id;

    private DiaSemana diaSemana;
    private Hora hora;
    private TipoActividad tipoActividad;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    private Grupo grupo;

    @ManyToOne
    private Asignatura asignatura;

    @OneToOne(mappedBy = "horario")
    private Asignacion asignacion;

    public Horario(Long id, DiaSemana diaSemana, Hora hora, Profesor profesor, TipoActividad tipoActividad, Grupo grupo, Asignatura asignatura, Asignacion asignacion) {
        this.id = id;
        this.diaSemana = diaSemana;
        this.hora = hora;
        this.profesor = profesor;
        this.tipoActividad = tipoActividad;
        this.grupo = grupo;
        this.asignatura = asignatura;
        this.asignacion = asignacion;
    }

    public Horario() {}

    public Long getId() {
        return id;
    }

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

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
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

    public Asignacion getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(Asignacion asignacion) {
        this.asignacion = asignacion;
    }
}
