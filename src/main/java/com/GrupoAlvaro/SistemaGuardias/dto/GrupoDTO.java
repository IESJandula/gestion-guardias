package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class GrupoDTO {
    private String nombre;
    private String datos;

    public GrupoDTO() {}

    public GrupoDTO(String nombre, String datos) {
        this.nombre = nombre;
        this.datos = datos;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}

