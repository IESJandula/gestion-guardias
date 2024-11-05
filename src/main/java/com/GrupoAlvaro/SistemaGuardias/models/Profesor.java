package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;

    @OneToMany(mappedBy = "profesor")
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesor")
    private List<Guardia> guardias;

    @OneToMany(mappedBy = "profesor")
    private List<Ausencia> ausencias;





}
