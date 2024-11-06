package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Relación con AsignaturaProfesorGrupo
    @OneToMany(mappedBy = "asignatura")
    private List<AsignaturaProfesorGrupo> asignaturaProfesoresGrupos;

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

    public List<AsignaturaProfesorGrupo> getAsignaturaProfesores() {
        return asignaturaProfesoresGrupos;
    }

    public void setAsignaturaProfesores(List<AsignaturaProfesorGrupo> asignaturaProfesoresGrupos) {
        this.asignaturaProfesoresGrupos = asignaturaProfesoresGrupos;
    }
}
