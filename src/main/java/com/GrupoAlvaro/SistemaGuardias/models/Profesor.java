package com.GrupoAlvaro.SistemaGuardias.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String nombre;

    // Relación unidireccional con horario
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Horario> horario;

    @OneToMany(mappedBy = "profesorAusente")
    private List<Ausencia> ausencias;

    @OneToMany(mappedBy = "profesor")
    private List<Asignacion> asignacionesGuardia;

    @OneToMany(mappedBy = "profesor")  // Relación con Grupo
    private List<Grupo> grupo;  // Aquí se mapea con "profesor" de Grupo

    @ManyToMany
    @JoinTable(
            name = "profesor_asignatura", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "profesor_id"),  // Columna que referencia a profesor
            inverseJoinColumns = @JoinColumn(name = "asignatura_id")  // Columna que referencia a asignatura
    )
    private List<Asignatura> asignaturas;

    private Long contadorSustituciones;


    public Profesor() {}

    public Profesor(Long id, String email, String nombre, List<Horario> horario, List<Ausencia> ausencias, List<Asignacion> asignacionesGuardia, List<Grupo> grupo, List<Asignatura> asignaturas, Long contadorSustituciones) {
        this.id = id;
        this.email = email;
        this.nombre = nombre;
        this.horario = horario;
        this.ausencias = ausencias;
        this.asignacionesGuardia = asignacionesGuardia;
        this.grupo = grupo;
        this.asignaturas = asignaturas;
        this.contadorSustituciones = contadorSustituciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Grupo> getGrupo() {
        return grupo;
    }

    public void setGrupo(List<Grupo> grupo) {
        this.grupo = grupo;
    }

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

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public List<Horario> getHorario() {
        return horario;
    }

    public void setHorario(List<Horario> horario) {
        this.horario = horario;
    }

    public List<Ausencia> getAusencias() {
        return ausencias;
    }

    public void setAusencias(List<Ausencia> ausencias) {
        this.ausencias = ausencias;
    }

    public List<Asignacion> getAsignacionesGuardia() {
        return asignacionesGuardia;
    }

    public void setAsignacionesGuardia(List<Asignacion> asignacionesGuardia) {
        this.asignacionesGuardia = asignacionesGuardia;
    }

    public Long getContadorSustituciones() {
        return contadorSustituciones;
    }

    public void setContadorSustituciones(Long contadorSustituciones) {
        this.contadorSustituciones = contadorSustituciones;
    }
}
