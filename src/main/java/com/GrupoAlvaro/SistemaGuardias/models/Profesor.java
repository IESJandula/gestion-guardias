package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "profesores")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(columnDefinition = "jsonb")
    private String horario;

    @OneToMany(mappedBy = "profesor")
    private List<Guardia> guardias;

    @OneToMany(mappedBy = "profesor")
    private List<Ausencia> ausencias;

    // Getters y Setters
}
