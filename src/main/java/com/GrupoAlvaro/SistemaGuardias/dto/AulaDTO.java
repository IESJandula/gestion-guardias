package com.GrupoAlvaro.SistemaGuardias.dto;

public class AulaDTO {

    private String nombre;
    private String ubicacion;

    public AulaDTO(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public AulaDTO() {}

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
