package com.GrupoAlvaro.SistemaGuardias.dto;

import com.GrupoAlvaro.SistemaGuardias.models.Asignatura;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ProfesorDTO {

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;
    @NotBlank(message = "El email no puede estar vacío")
    private String email;
    @NotEmpty(message = "La asignatura tiene que tener todos los datos")
    private List<Asignatura> asignatura;
    @NotEmpty(message = "El grupo tiene que tener todos los datos")
    private List<Grupo> grupo;

    public ProfesorDTO(String nombre, String email, List asignatura, List grupo) {
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

    public List<Asignatura> getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(List asignatura) {
        this.asignatura = asignatura;
    }

    public List getGrupo() {
        return grupo;
    }

    public void setGrupo(List grupo) {
        this.grupo = grupo;
    }
}

