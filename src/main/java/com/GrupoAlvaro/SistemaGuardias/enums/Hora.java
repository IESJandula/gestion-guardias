package com.GrupoAlvaro.SistemaGuardias.enums;

public enum Hora {
    PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA, SEXTA;

    // Metodo para obtener el valor Integer correspondiente
    public int toInteger() {
        return this.ordinal() + 1; // Asigna 1 a PRIMERA, 2 a SEGUNDA, etc.
    }

}
