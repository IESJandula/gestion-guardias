package com.GrupoAlvaro.SistemaGuardias.dto;

import java.util.List;

public class GrupoDTO {
    private String nombre;
    private String datos;
    private static boolean esConflictivo;

    public GrupoDTO() {}

    public GrupoDTO(String nombre, String datos) {
        this.nombre = nombre;
        this.datos = datos;
    }

    public boolean traducirConflictivo(String datos) {
        if(datos=="Si"){
            return esConflictivo=true;
        }else {
            return esConflictivo = false;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static boolean isEsConflictivo() {
        return esConflictivo;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }
}

