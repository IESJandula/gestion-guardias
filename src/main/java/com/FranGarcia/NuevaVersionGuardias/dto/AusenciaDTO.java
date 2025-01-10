package com.FranGarcia.NuevaVersionGuardias.dto;

import java.time.LocalDate;


public class AusenciaDTO {
    private Long id;    //Id de la ausencia
    private LocalDate fecha;  // Fecha de la ausencia
    private String profesorAusenteEmail;  // Email del profesor ausente
    private String hora;  // Hora de la ausencia (usando String para simplificar la representación)
    private String tarea;  // Tarea asignada a esa hora

    // Constructor
    public AusenciaDTO() {}

    //Constructor que maneja el id, ncesario para asignar coberturas y eliminar ausencias
    public AusenciaDTO(Long id, LocalDate fecha, String profesorAusenteEmail, String hora, String tarea) {
        this.id = id;
        this.fecha = fecha;
        this.profesorAusenteEmail = profesorAusenteEmail;
        this.hora = hora;
        this.tarea = tarea;
    }

    //Constructor sin ID, cuando no nos interesa almacenar su id por ejemplo en el tema de visualizaciones
    public AusenciaDTO(LocalDate fecha, String profesorAusenteEmail, String hora, String tarea) {
        this.fecha = fecha;
        this.profesorAusenteEmail = profesorAusenteEmail;
        this.hora = hora;
        this.tarea = tarea;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getProfesorAusenteEmail() {
        return profesorAusenteEmail;
    }

    public void setProfesorAusenteEmail(String profesorAusenteEmail) {
        this.profesorAusenteEmail = profesorAusenteEmail;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
}


