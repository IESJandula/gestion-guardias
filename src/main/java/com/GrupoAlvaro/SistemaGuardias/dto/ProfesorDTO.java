package com.GrupoAlvaro.SistemaGuardias.dto;

public class ProfesorDTO {

    private String nombre;
    private String email;
    private String asignatura;
    private String grupo;

    public ProfesorDTO(String nombre, String email, String asignatura, String grupo) {
        this.nombre = nombre;
        this.email = email;
        this.asignatura = asignatura;
        this.grupo = grupo;
    }

    public ProfesorDTO() {}

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}

