package com.GrupoAlvaro.SistemaGuardias.dto;

public class NotificacionDTO {

    private String mensaje;
    private byte[] justificanteMedico;
    private Long profesorId; // ID del profesor relacionado

    public NotificacionDTO(String mensaje, byte[] justificanteMedico, Long profesorId) {
        this.mensaje = mensaje;
        this.justificanteMedico = justificanteMedico;
        this.profesorId = profesorId;
    }

    public NotificacionDTO() {}

    // Getters y setters

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public byte[] getJustificanteMedico() {
        return justificanteMedico;
    }

    public void setJustificanteMedico(byte[] justificanteMedico) {
        this.justificanteMedico = justificanteMedico;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }
}

