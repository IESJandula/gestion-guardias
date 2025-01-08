package com.FranGarcia.NuevaVersionGuardias.models;

import jakarta.persistence.*;

@Entity
public class Cobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ausencia_id", nullable = false, unique = true)
    private Ausencia ausencia;

    @ManyToOne
    @JoinColumn(name = "profesor_email", nullable = false)
    private Profesor profesorCubre;

    public Cobertura() {}

    public Cobertura(Ausencia ausencia, Profesor profesorCubre) {
        this.ausencia = ausencia;
        this.profesorCubre = profesorCubre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ausencia getAusencia() {
        return ausencia;
    }

    public void setAusencia(Ausencia ausencia) {
        this.ausencia = ausencia;
    }

    public Profesor getProfesorCubre() {
        return profesorCubre;
    }

    public void setProfesorCubre(Profesor profesorCubre) {
        this.profesorCubre = profesorCubre;
    }
}
