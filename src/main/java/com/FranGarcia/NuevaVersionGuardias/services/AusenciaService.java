package com.FranGarcia.NuevaVersionGuardias.services;

import com.FranGarcia.NuevaVersionGuardias.dto.AusenciaDTO;
import com.FranGarcia.NuevaVersionGuardias.enums.HoraDia;
import com.FranGarcia.NuevaVersionGuardias.models.*;
import com.FranGarcia.NuevaVersionGuardias.repositories.AusenciaRepository;
import com.FranGarcia.NuevaVersionGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

        return ausenciaRepository.save(ausencia);
    }

    //El objetivo de este metodo es tener un mapa cuya clave va a ser la hora del dia y el valor que sera una lista con todas las ausencias de dicha hora
    public Map<String, List<AusenciaDTO>> listarAusenciasPorFechaAgrupadasPorHora(LocalDate fecha) {
        //Obtenemos todas las ausencias de la fecha indicada
        List<Ausencia> ausencias = ausenciaRepository.findByFecha(fecha);

        //Creamos un mapa para agrupar las ausencias por hora, para facilitar el trabajao al front y que salgan ya agrupadas por hora
        Map<String, List<AusenciaDTO>> ausenciasPorHora = new HashMap<>();

        //Recorremos cada ausencia y para ver a que hora del dia es
        for (Ausencia ausencia : ausencias) {
            //Sacamos la hora
            String hora = ausencia.getHora().name();

            //Creamos un DTO de la ausencia para registrarla en el mapa, porque no queremos guardar su id por ejemplo
            AusenciaDTO ausenciaDTO = new AusenciaDTO(
                    ausencia.getFecha(), // Fecha de la ausencia
                    ausencia.getProfesorAusente().getEmail(), // Email del profesor ausente
                    ausencia.getHora().name(), // Hora de la ausencia (como texto)
                    ausencia.getTarea() // Descripción de la tarea
            );

            // Agrupamos las ausencias por hora en el mapa
            // Si ya existe una lista de ausencias para esa hora, la agregamos a la lista existente
            // Si no, creamos una nueva lista y agregamos la ausencia
            if (!ausenciasPorHora.containsKey(hora)) {
                ausenciasPorHora.put(hora, new ArrayList<>());
            }
            ausenciasPorHora.get(hora).add(ausenciaDTO);
        }

        return ausenciasPorHora;
    }





    /*
    Metodo para registrar ausencias y que se generen coberturas automaticamente
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

     */


}
