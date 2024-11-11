package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;

import java.time.LocalDate;
import java.util.List;

public class AusenciaDTO {

    private String profesorEmail;
    private LocalDate fecha;
    private List<Hora> horas;
    private List<DetalleAusenciaDTO> detalles;

    public AusenciaDTO(String profesorEmail, LocalDate fecha, List<Hora> horas, List<DetalleAusenciaDTO> detalles) {
        this.profesorEmail = profesorEmail;
        this.fecha = fecha;
        this.horas = horas;
        this.detalles = detalles;
    }

    public String getProfesorEmail() {
        return profesorEmail;
    }

    public void setProfesorEmail(String profesorEmail) {
        this.profesorEmail = profesorEmail;
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

