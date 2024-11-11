package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import com.GrupoAlvaro.SistemaGuardias.enums.TipoAsignacion;
import jakarta.persistence.*;

@Entity
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private TipoAsignacion tipoAsignacion;
    private DiaSemana diaSemana;
    private Hora hora;

    @ManyToOne
    private Profesor profesor;

    @ManyToOne
    private Ausencia ausencia;

    @OneToOne
    private Aula aula;

    @OneToOne
    @JoinColumn(name = "guardia_id") // Nombre de la columna que será la clave foránea en Asignacion
    private Guardia guardia;

    @OneToOne
    @JoinColumn(name = "horario_id") // Nombre de la columna que será la clave foránea en Asignacion
    private Horario horario;


    public Asignacion() {}

    public Asignacion(TipoAsignacion tipoAsignacion, DiaSemana diaSemana, Hora hora){
        this.tipoAsignacion = tipoAsignacion;
        this.diaSemana = diaSemana;
        this.hora = hora;
        profesor.setContadorSustituciones(profesor.getContadorSustituciones()+1);       //Cada vez que se le asigne una guardia al profesor se le sumara al contador
    }

    public Long getId() {
        return id;
    }

    public TipoAsignacion getTipoAsignacion() {
        return tipoAsignacion;
    }

    public void setTipoAsignacion(TipoAsignacion tipoAsignacion) {
        this.tipoAsignacion = tipoAsignacion;
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Ausencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(Ausencia ausencia) {
        this.ausencia = ausencia;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

}
