package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;

import java.util.List;

public class ProfesorDTO {

    private String nombre;
    private String email;

    public ProfesorDTO(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
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

}

