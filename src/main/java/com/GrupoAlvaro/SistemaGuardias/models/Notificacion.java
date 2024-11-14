package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    private LocalDateTime fechaHora;  // Fecha y hora de la notificación

    @Lob
    private byte[] justificanteMedico;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;  // Relación con el profesor que emite la notificación

    public Notificacion() {}

    public Notificacion(String mensaje, byte[] justificanteMedico, Profesor profesor) {
        this.mensaje = mensaje;
        this.justificanteMedico = justificanteMedico;
        this.profesor = profesor;
        this.fechaHora = LocalDateTime.now();
    }

    // Getters y setters

    public Long getId() {
        return id;
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

    public byte[] getJustificanteMedico() {
        return justificanteMedico;
    }

    public void setJustificanteMedico(byte[] justificanteMedico) {
        this.justificanteMedico = justificanteMedico;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}

