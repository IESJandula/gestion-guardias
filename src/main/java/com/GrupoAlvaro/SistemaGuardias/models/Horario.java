package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.TipoHora;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Horario {

    @EmbeddedId
    private HorarioId id; // Clave primaria compuesta

    @ManyToOne
    @MapsId("idProfesor") // Mapear idProfesor desde Profesor
    @JoinColumn(name = "id_profesor")
    private Profesor profesor;

    private String nombre; // Nombre de la materia o actividad para esa hora

    // Otros campos si necesitas, por ejemplo:
    private String actividad; // Otra descripción para la tarea

    // Constructor vacío requerido por JPA
    protected Horario() {}

    // Constructor con todos los atributos
    public Horario(HorarioId id, Profesor profesor, String nombre, String actividad) {
        this.id = id;
        this.profesor = profesor;
        this.nombre = nombre;
        this.actividad = actividad;
    }

    // Getters y setters

    public HorarioId getId() {
        return id;
    }

    public void setId(HorarioId id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
}
