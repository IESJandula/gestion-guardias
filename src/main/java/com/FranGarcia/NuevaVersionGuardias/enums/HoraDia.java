package com.FranGarcia.NuevaVersionGuardias.enums;

public enum HoraDia {
    PRIMERA("1"),
    SEGUNDA("2"),
    TERCERA("3"),
    CUARTA("4"),
    QUINTA("5"),
    SEXTA("6");

    private final String valor;

    // Constructor
    HoraDia(String valor) {
        this.valor = valor;
    }

    // Getter
    public String getValor() {
        return valor;
    }

    // Metodo estático para convertir de un String al Enum correspondiente
    public static HoraDia valueOfHora(String valor) {
        for (HoraDia horaDia : values()) {
            if (horaDia.getValor().equals(valor)) {
                return horaDia;
            }
        }
        throw new IllegalArgumentException("Hora no válida: " + valor);
    }
}


