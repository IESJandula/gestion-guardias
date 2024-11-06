package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Sustitucion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Profesor que cubre la sustitución
    @ManyToOne
    @JoinColumn(name = "id_profesor_guardia")
    private Profesor profesorGuardia;

    // Grupo que va a recibir la sustitución
    @ManyToOne
    @JoinColumn(name = "id_grupo")
    private Grupo grupo;


    // Aula en la que se imparte la sustitución
    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;  // Relacionado con Aula

    private Boolean realizado;  // Si la sustitución fue efectuada o no

    // Constructor vacío
    protected Sustitucion() {}

    // Constructor con parámetros
    public Sustitucion(Profesor profesorGuardia, Grupo grupo, Aula aula, Boolean realizado) {
        this.profesorGuardia = profesorGuardia;
        this.grupo = grupo;
        this.aula = aula;
        this.realizado = realizado;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfesorGuardia() {
        return profesorGuardia;
    }

    public void setProfesorGuardia(Profesor profesorGuardia) {
        this.profesorGuardia = profesorGuardia;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }



    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Boolean getRealizado() {
        return realizado;
    }

    public void setRealizado(Boolean realizado) {
        this.realizado = realizado;
    }
}
