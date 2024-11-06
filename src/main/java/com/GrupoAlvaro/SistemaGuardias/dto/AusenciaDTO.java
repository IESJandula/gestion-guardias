package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;

import java.time.LocalDate;
import java.util.List;

public class AusenciaDTO {

    private Long id;
    private String profesorNombre;
    private LocalDate fecha;
    private List<Hora> horas;
    private List<DetalleAusenciaDTO> detalles;

    public AusenciaDTO(Long id, String profesorNombre, LocalDate fecha, List<Hora> horas, List<DetalleAusenciaDTO> detalles) {
        this.id = id;
        this.profesorNombre = profesorNombre;
        this.fecha = fecha;
        this.horas = horas;
        this.detalles = detalles;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
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

    public List<DetalleAusenciaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleAusenciaDTO> detalles) {
        this.detalles = detalles;
    }
}

