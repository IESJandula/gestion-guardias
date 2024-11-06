package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class DetalleAusencia {

    // Relación con la entidad Ausencia. El id de ausencia sera su clave primaria
    @Id
    @ManyToOne
    @JoinColumn(name = "id_ausencia")
    private Ausencia ausencia;

    // El grupo afectado
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;

    // La asignatura que se imparte durante esa clase
    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    // Tarea que debe realizar el grupo durante la ausencia
    private String tarea;

    // Hora específica de la clase que se pierde
    @Enumerated(EnumType.STRING)  // Guardamos la hora como texto en la base de datos
    private Hora hora;  // Utilizamos el enum Hora para reflejar la hora


    public DetalleAusencia() {}


    public DetalleAusencia(Ausencia ausencia, Grupo grupo, Asignatura asignatura, String tarea, Hora hora) {
        this.ausencia = ausencia;
        this.grupo = grupo;
        this.asignatura = asignatura;
        this.tarea = tarea;
        this.hora = hora;
    }


    public Ausencia getAusencia() {
        return ausencia;
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

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }
}
