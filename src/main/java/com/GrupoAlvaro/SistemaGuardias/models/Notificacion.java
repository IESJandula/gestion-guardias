package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaHora;    //Fecha y hora de la notificacion

    @Lob
    private byte[] justificanteMedico;

    public Notificacion() {}

    public Notificacion(String mensaje, byte[] justificanteMedico) {
        this.mensaje = mensaje;
        this.justificanteMedico = justificanteMedico;
        this.fechaHora = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public byte[] getJustificanteMedico() {
        return justificanteMedico;
    }

    public void setJustificanteMedico(byte[] justificanteMedico) {
        this.justificanteMedico = justificanteMedico;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}
