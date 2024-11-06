package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity

public class Ausencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Profesor que está ausente
    @ManyToOne
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    // Fecha de la ausencia
    private LocalDate fecha;  // Fecha específica de la ausencia

    // Lista de horas en las que el profesor está ausente
    @ElementCollection(targetClass = Hora.class)
    @Enumerated(EnumType.STRING)  // Guardamos las horas como texto en la base de datos
    private List<Hora> horas;  // Ejemplo: [PRIMERA, TERCERA, QUINTA]

    // Lista de detalles de ausencia (clases que se pierden durante la ausencia)
    @OneToMany(mappedBy = "ausencia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleAusencia> detalles;


    public Ausencia() {}


    public Ausencia(Profesor profesor, LocalDate fecha, List<Hora> horas) {
        this.profesor = profesor;
        this.fecha = fecha;
        this.horas = horas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public List<Hora> getHoras() {
        return horas;
    }

    public void setHoras(List<Hora> horas) {
        this.horas = horas;
    }

    public List<DetalleAusencia> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleAusencia> detalles) {
        this.detalles = detalles;
    }
}


