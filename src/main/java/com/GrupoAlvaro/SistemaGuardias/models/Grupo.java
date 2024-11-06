package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;  // Ejemplo: "1A", "2B"

    // Relación con el horario del grupo
    @OneToMany(mappedBy = "grupo")
    private List<Horario> horarios;

    // Relación con las aulas asignadas
    @ManyToMany
    @JoinTable(
            name = "grupo_aula",
            joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "aula_id")
    )
    private List<Aula> aulas;

    // Relación con las sustituciones de este grupo
    @OneToMany(mappedBy = "grupo")
    private List<Sustitucion> sustituciones;

    // Relación con AsignaturaProfesor
    @OneToMany(mappedBy = "grupo")
    private List<AsignaturaProfesorGrupo> asignaturaProfesoresGrupos;

    // Constructor vacío
    protected Grupo() {}

    // Constructor con parámetros
    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Sustitucion> getSustituciones() {
        return sustituciones;
    }

    public void setSustituciones(List<Sustitucion> sustituciones) {
        this.sustituciones = sustituciones;
    }

    public List<AsignaturaProfesorGrupo> getAsignaturaProfesoresGrupos() {
        return asignaturaProfesoresGrupos;
    }

    public void setAsignaturaProfesores(List<AsignaturaProfesorGrupo> asignaturaProfesoresGrupos) {
        this.asignaturaProfesoresGrupos = asignaturaProfesoresGrupos;
    }
}
