package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.enums.Hora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public class AusenciaDTO {

    @NotBlank(message = "El email no puede estar vacío")
    private String profesorEmail;
    @NotBlank(message = "La fecha no puede estar vacío")
    private LocalDate fecha;
    @NotEmpty(message = "La lista de horas no puede estar vacía")
    private List<Hora> horas;
    @NotEmpty(message = "La lista de detalles no puede estar vacía")
    private List<DetalleAusenciaDTO> detalles;
    @NotNull(message = "Tienes que mandar un justificante médico.")
    private byte[] justificanteMedico;

    public AusenciaDTO(String profesorEmail, LocalDate fecha, List<Hora> horas, List<DetalleAusenciaDTO> detalles, byte[] justificanteMedico) {
        this.profesorEmail = profesorEmail;
        this.fecha = fecha;
        this.horas = horas;
        this.detalles = detalles;
        this.justificanteMedico = justificanteMedico;
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

    public byte[] getJustificanteMedico() {
        return justificanteMedico;
    }

    public void setJustificanteMedico(byte[] justificanteMedico) {
        this.justificanteMedico = justificanteMedico;
    }
}

