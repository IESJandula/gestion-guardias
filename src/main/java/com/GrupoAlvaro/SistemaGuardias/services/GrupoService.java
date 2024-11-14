package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.GrupoDTO;
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


    @Transactional
    public void crearGrupo(Grupo grupo) {
         grupoRepository.save(grupo);
    }

    public List<Grupo> listarGrupos() {
        return grupoRepository.findAll();
    }

    public Optional<Grupo> obtenerGrupo(String nombre) {
        return grupoRepository.findByNombre(nombre);
    }

    //Metodo para actualizar el grupo
    @Transactional
    public void actualizarGrupo(String nombre, GrupoDTO grupoDTO) {
        Optional<Grupo> grupoOpt = grupoRepository.findByNombre(nombre);
        if (grupoOpt.isPresent()) {
            Grupo grupo = grupoOpt.get();
            grupo.setEsConflictivo(grupoDTO.getDatos());
            grupoRepository.save(grupo);
        }
    }

    @Transactional
    public void eliminarGrupo(Long id) {
        grupoRepository.deleteById(id);
    }
}
