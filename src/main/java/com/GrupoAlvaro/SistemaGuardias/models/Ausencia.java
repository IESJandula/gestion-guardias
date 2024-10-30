package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ausencias")
public class Ausencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    private LocalDate fecha;
    private Integer horas;
    private String tareas;

    // Getters y Setters
}

