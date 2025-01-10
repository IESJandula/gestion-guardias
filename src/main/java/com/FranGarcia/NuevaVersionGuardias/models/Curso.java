package com.FranGarcia.NuevaVersionGuardias.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ejemplo: "1ºESO-A"

    @ManyToOne
    @JoinColumn(name = "aula_base_id", nullable = false)
    private Aula aulaBase; // Relación con el aula base. Puede haber varios cursos cuya aula sea la misma, aunque no simultaneamente, se controlara mediante los horarios

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HorarioCurso> horarios = new ArrayList<>();

    public Curso() {}

    public Curso(String nombre, Aula aulaBase) {
        this.nombre = nombre;
        this.aulaBase = aulaBase;
    }


}

