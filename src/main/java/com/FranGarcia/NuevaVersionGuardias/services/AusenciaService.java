package com.FranGarcia.NuevaVersionGuardias.services;

import com.FranGarcia.NuevaVersionGuardias.dto.AusenciaDTO;
import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import com.FranGarcia.NuevaVersionGuardias.models.*;
import com.FranGarcia.NuevaVersionGuardias.repositories.AusenciaRepository;
import com.FranGarcia.NuevaVersionGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AusenciaService {
    @Autowired
    private ProfesorRepository profesorRepository; // Para obtener el profesor
    @Autowired
    private AusenciaRepository ausenciaRepository; // Para guardar la ausencia
    @Autowired
    private CoberturaService coberturaService;

    @Transactional
    public Ausencia registrarAusencia(AusenciaDTO ausenciaDTO) throws Exception {
        // Validamos que el profesor que registra la ausencia sea válido
        Profesor profesor = profesorRepository.findByEmail(ausenciaDTO.getProfesorAusenteEmail())
                .orElseThrow(() -> new Exception("Profesor no encontrado"));

        // Creamos la ausencia con los datos que nos pasan por el DTO
        Ausencia ausencia = new Ausencia();
        ausencia.setFecha(ausenciaDTO.getFecha());
        ausencia.setHora(HoraDia.valueOf(ausenciaDTO.getHora()));
        ausencia.setProfesorAusente(profesor);
        ausencia.setTarea(ausenciaDTO.getTarea());

        try {
            // Llamada al metodo para generar automáticamente la cobertura
            Cobertura cobertura = coberturaService.generarCobertura(ausencia);

            // Asociamos la cobertura a la ausencia
            ausencia.setCobertura(cobertura);
        } catch (Exception e) {
            // Manejo del caso donde no haya profesores disponibles
            ausencia.setCobertura(null);
            throw new Exception("No se pudo generar una cobertura: " + e.getMessage());
        }

        // Guardamos la ausencia
        return ausenciaRepository.save(ausencia);
    }


}
