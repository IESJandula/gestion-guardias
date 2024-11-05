package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String abreviatura;
    private String nombre;
    private String nivel;
    private String curso;

    @OneToMany(mappedBy = "asignatura")
    private List<Horario> horarios;


}
