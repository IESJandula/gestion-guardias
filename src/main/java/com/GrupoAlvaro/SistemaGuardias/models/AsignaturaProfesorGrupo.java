package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;
/*
    Este es un Join Table para la relación entre Profesor, Asignatura y Grupo,
    ya que un Profesor puede impartir diferentes Asignaturas y estos pueden estar
    relacionados con diferentes Grupos.
 */

@Entity
public class AsignaturaProfesorGrupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "id_asignatura")
    private Asignatura asignatura;

    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;


    public AsignaturaProfesorGrupo() {}


    public AsignaturaProfesorGrupo(Profesor profesor, Asignatura asignatura, Grupo grupo) {
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.grupo = grupo;
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

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
