package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;

import java.time.LocalDate;
import java.util.List;

public class AusenciaDTO {

    private String profesorEmail;
    private LocalDate fechaInicio, fechaFin;
    private List<Hora> horas;
    private List<DetalleAusenciaDTO> detalles;

    public AusenciaDTO(String profesorEmail, LocalDate fechaInicio, LocalDate fechaFin, List<Hora> horas, List<DetalleAusenciaDTO> detalles) {
        this.profesorEmail = profesorEmail;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.horas = horas;
        this.detalles = detalles;
    }

    public String getProfesorEmail() {
        return profesorEmail;
    }

    public void setProfesorEmail(String profesorEmail) {
        this.profesorEmail = profesorEmail;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
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

