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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AusenciaService {

    @Autowired
    private AusenciaRepository ausenciaRepository;

    @Autowired
    private ProfesorService profesorService;

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

        Profesor profesor = profesorService.buscarProfesorById(ausenciaDTO.getProfesorEmail());
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


    public Optional<List<Ausencia>> buscarAusenciasByFecha(LocalDate fecha) {
        // Lista para almacenar las ausencias encontradas
        List<Ausencia> ausenciasHoy = new ArrayList<>();

        // Obtener todas las ausencias de una sola vez (idealmente esto debería ser hecho con un filtro en la base de datos)
        List<Ausencia> todasLasAusencias = ausenciaRepository.findAll();

        // Filtrar las ausencias para encontrar las que coinciden con la fecha
        for (Ausencia ausencia : todasLasAusencias) {
            if (ausencia.getFechaInicio().isEqual(fecha)) {
                ausenciasHoy.add(ausencia);
            }
        }

        // Retornar las ausencias encontradas envueltas en un Optional
        return ausenciasHoy.isEmpty() ? Optional.empty() : Optional.of(ausenciasHoy);
    }
}
