package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.GrupoDTO;
import com.GrupoAlvaro.SistemaGuardias.models.Clase;
import com.GrupoAlvaro.SistemaGuardias.models.Grupo;
import com.GrupoAlvaro.SistemaGuardias.repositories.AusenciaRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ClaseRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.GrupoRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.TareaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GrupoService {
    @Autowired
    private GrupoRepository grupoRepository;

    @Autowired
    private ClaseRepository claseRepository;

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private AusenciaRepository ausenciaRepository;

    //Operaciones Crud
    //Metodo para crear un grupo
    public Grupo crearGrupo(GrupoDTO grupo) {
        Grupo g = new Grupo(grupo.getNombre(), grupo.traducirConflictivo(grupo.getDatos()));
        return grupoRepository.save(g);
    }

    //Metodo para borrar un grupo
    @Transactional
    public void eliminarGrupo(Long id) {
        Optional<Grupo> grupo = grupoRepository.findById(id);
        if (grupo.isPresent()) {
            System.out.println("Eliminando el grupo con id: " + id);
            claseRepository.deleteById(id);
        } else {
            System.out.println("El grupo con esta id"+id +" o existe");
        }}


    //Metodos para mostrar cosas
    //Metodo para mostrar todas las clases
    @Transactional
    public List<Grupo> mostrarClases() {return grupoRepository.findAll();}

    //Metodo para mostrar el grupo con id especifica
    @Transactional
    public Grupo mostrarGrupoPorId(Long id) {
        return grupoRepository.findById(id).orElseThrow(() -> new RuntimeException("Grupo no encontrado con el ID: " + id));
    }

    //Metodo para actualizar el grupo
    @Transactional
    public Grupo modificarGrupo(Long id, Grupo grupoActualizado) {
        Grupo grupo = grupoRepository.findById(id).orElseThrow(() -> new RuntimeException("Clase no encontrada con el ID: " + id));

        grupo.setNombre(grupoActualizado.getNombre());
        grupo.setEsConflictivo(grupoActualizado.isEsConflictivo());
        grupo.setAsignaturas(grupoActualizado.getAsignaturas());
        grupo.setClases(grupoActualizado.getClases());
        grupo.setTareas(grupoActualizado.getTareas());
        grupo.setAusencias(grupoActualizado.getAusencias());

        return grupoRepository.save(grupo);
    }

}
