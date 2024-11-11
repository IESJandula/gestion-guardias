package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.dto.AusenciaDTO;
import com.GrupoAlvaro.SistemaGuardias.exception.ResourceNotFoundException;
import com.GrupoAlvaro.SistemaGuardias.models.Ausencia;
import com.GrupoAlvaro.SistemaGuardias.models.Profesor;
import com.GrupoAlvaro.SistemaGuardias.repositories.AusenciaRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AusenciaService {

    @Autowired
    private AusenciaRepository ausenciaRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Ausencia> listarAusencias() {
        return ausenciaRepository.findAll();
    }

    public Optional<Ausencia> buscarAusenciaById(Long id) {
        return ausenciaRepository.findById(id);
    }

    @Transactional
    public void eliminarAusencia(Long id) {
        ausenciaRepository.deleteById(id);
    }

    @Transactional
    public Optional<Ausencia> modificarAusencia(Long id, Ausencia ausenciaModificada) {
        Optional<Ausencia> ausencia = ausenciaRepository.findById(id);
        if(ausencia.isPresent()){
            ausencia.get().setFechaInicio(ausenciaModificada.getFechaInicio());
            ausencia.get().setFechaFin(ausenciaModificada.getFechaFin());
            ausenciaRepository.save(ausencia.get());
        }else {
            throw new ResourceNotFoundException("Ausencia no encontrada");
        }
        return ausencia;
    }

    @Transactional
    public void registrarAusencia(AusenciaDTO ausenciaDTO) {

        Profesor profesor = profesorRepository.findByEmail(ausenciaDTO.getProfesorEmail());
        if(profesor == null){
            throw new ResourceNotFoundException("Profesor no encontrado");
        }

        Ausencia ausencia = new Ausencia(
                profesor,
                ausenciaDTO.getFechaInicio(),
                ausenciaDTO.getFechaFin(),
                ausenciaDTO.getHoras());

        ausenciaRepository.save(ausencia);

    }





}
