package com.GrupoAlvaro.SistemaGuardias.models;

import com.GrupoAlvaro.SistemaGuardias.enums.DiaSemana;
import com.GrupoAlvaro.SistemaGuardias.enums.TipoHora;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class HorarioId implements Serializable {

    private Long idProfesor;
    private DiaSemana diaSemana;
    private TipoHora tipoHora;

    public HorarioId() {}

    public HorarioId(Long idProfesor, DiaSemana diaSemana, TipoHora tipoHora) {
        this.idProfesor = idProfesor;
        this.diaSemana = diaSemana;
        this.tipoHora = tipoHora;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public TipoHora getTipoHora() {
        return tipoHora;
    }

    public void setTipoHora(TipoHora tipoHora) {
        this.tipoHora = tipoHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HorarioId horarioId = (HorarioId) o;
        return Objects.equals(idProfesor, horarioId.idProfesor) &&
                Objects.equals(diaSemana, horarioId.diaSemana) &&
                Objects.equals(tipoHora, horarioId.tipoHora);
    }

    // Implementación de hashCode
    @Override
    public int hashCode() {
        return Objects.hash(idProfesor, diaSemana, tipoHora);
    }
}
