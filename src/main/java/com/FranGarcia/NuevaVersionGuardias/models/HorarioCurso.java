package com.FranGarcia.NuevaVersionGuardias.models;

import com.FranGarcia.NuevaVersionGuardias.enums.Asignatura;
import com.FranGarcia.NuevaVersionGuardias.enums.DiaSemana;
import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import jakarta.persistence.*;

@Entity
public class HorarioCurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "aula_id", nullable = false)
    private Aula aula; // Aula específica para esta hora

    @ManyToOne
    @JoinColumn(name = "profesor_email", nullable = false)
    private Profesor profesor;

    private Asignatura asignatura;

    @Enumerated(EnumType.STRING)
    private DiaSemana diaSemana;

    @Enumerated(EnumType.STRING)
    private HoraDia horaDia;

    public HorarioCurso() {}

    public HorarioCurso(Curso curso, Aula aula, Profesor profesor, Asignatura asignatura, DiaSemana diaSemana, HoraDia horaDia) {
        this.curso = curso;
        this.aula = aula;
        this.profesor = profesor;
        this.asignatura = asignatura;
        this.diaSemana = diaSemana;
        this.horaDia = horaDia;
    }


}

