package com.FranGarcia.NuevaVersionGuardias.models;

import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import jakarta.persistence.*;
import java.time.LocalDate;
/*
    Una ausencia correspondera a una hora, con profesor que cubra
 */

@Entity
public class Ausencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "profesor_email", nullable = false)
    private Profesor profesorAusente;

    @Enumerated(EnumType.STRING)
    private HoraDia hora;

    private String tarea;

    @OneToOne(mappedBy = "ausencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cobertura cobertura;

    public Ausencia() {}

    public Ausencia(LocalDate fecha, Profesor profesorAusente, HoraDia hora, String tarea) {
        this.fecha = fecha;
        this.profesorAusente = profesorAusente;
        this.hora = hora;
        this.tarea = tarea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Profesor getProfesorAusente() {
        return profesorAusente;
    }

    public void setProfesorAusente(Profesor profesorAusente) {
        this.profesorAusente = profesorAusente;
    }

    public HoraDia getHora() {
        return hora;
    }

    public void setHora(HoraDia hora) {
        this.hora = hora;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Cobertura getCobertura() {
        return cobertura;
    }

    public void setCobertura(Cobertura cobertura) {
        this.cobertura = cobertura;
    }
}




