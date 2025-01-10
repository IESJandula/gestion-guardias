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
import java.util.*;


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

    public boolean eliminarFalta(LocalDate fecha, String hora, String emailProfesor) {
        // Buscamos la ausencia en la base de datos
        List<Ausencia> ausencias = ausenciaRepository.findByFechaAndHoraAndProfesorAusenteEmail(fecha, HoraDia.valueOf(hora), emailProfesor);

        if (!ausencias.isEmpty()) {
            // Eliminamos todas las ausencias coincidentes (en caso de duplicados)
            ausenciaRepository.deleteAll(ausencias);
            return true;
        }
        return false; // No se encontró la falta
    }

    //El objetivo de este metodo es tener un mapa cuya clave va a ser la hora del dia y el valor que sera una lista con todas las ausencias de dicha hora
    public Map<String, List<AusenciaDTO>> listarAusenciasPorFechaAgrupadasPorHora(LocalDate fecha) {
        // Obtenemos todas las ausencias de la fecha indicada
        List<Ausencia> ausencias = ausenciaRepository.findByFecha(fecha);

        // Creamos un mapa con un comparador que respeta el orden del enum
        Map<String, List<AusenciaDTO>> ausenciasPorHora = new TreeMap<>((hora1, hora2) -> {
            HoraDia h1 = HoraDia.valueOf(hora1);
            HoraDia h2 = HoraDia.valueOf(hora2);
            return h1.ordinal() - h2.ordinal();
        });

        // Recorremos cada ausencia para agruparlas por hora
        for (Ausencia ausencia : ausencias) {
            String hora = ausencia.getHora().name();

            AusenciaDTO ausenciaDTO = new AusenciaDTO(
                    ausencia.getFecha(),
                    ausencia.getProfesorAusente().getEmail(),
                    hora,
                    ausencia.getTarea()
            );

            ausenciasPorHora.computeIfAbsent(hora, k -> new ArrayList<>()).add(ausenciaDTO);
        }

        return ausenciasPorHora;
    }


    //Siguiendo la logica del metodo anterior, obtenemos el historico ordenado por fecha y despues por hora, esta vez usando TreeMap
    public Map<LocalDate, Map<String, List<AusenciaDTO>>> historicoFaltas() {
        // Obtenemos todas las ausencias
        List<Ausencia> ausenciasTodas = ausenciaRepository.findAll();

        // Creamos el TreeMap para las fechas
        Map<LocalDate, Map<String, List<AusenciaDTO>>> historicoFaltas = new TreeMap<>();

        for (Ausencia ausencia : ausenciasTodas) {
            LocalDate fecha = ausencia.getFecha();
            String hora = ausencia.getHora().name();

            AusenciaDTO ausenciaDTO = new AusenciaDTO(
                    ausencia.getFecha(),
                    ausencia.getProfesorAusente().getEmail(),
                    hora,
                    ausencia.getTarea()
            );

            historicoFaltas.computeIfAbsent(fecha, k -> new TreeMap<>((hora1, hora2) -> {
                HoraDia h1 = HoraDia.valueOf(hora1);
                HoraDia h2 = HoraDia.valueOf(hora2);
                return h1.ordinal() - h2.ordinal();
            })).computeIfAbsent(hora, k -> new ArrayList<>()).add(ausenciaDTO);
        }

        return historicoFaltas;
    }


    public Map<LocalDate, Map<String, List<AusenciaDTO>>> historicoFaltasPorProfesor(String emailProfesor) {
        // Obtenemos todas las ausencias del profesor
        List<Ausencia> ausenciasProfesor = ausenciaRepository.findAllByProfesorAusenteEmail(emailProfesor);

        // Creamos el TreeMap para las fechas
        Map<LocalDate, Map<String, List<AusenciaDTO>>> historicoFaltas = new TreeMap<>();

        for (Ausencia ausencia : ausenciasProfesor) {
            LocalDate fecha = ausencia.getFecha();
            String hora = ausencia.getHora().name();

            AusenciaDTO ausenciaDTO = new AusenciaDTO(
                    ausencia.getFecha(),
                    ausencia.getProfesorAusente().getEmail(),
                    hora,
                    ausencia.getTarea()
            );

            //Metodo auxiliar para almacenar las faltas por orden, para despues faciliar la visualizacion del backend
            historicoFaltas.computeIfAbsent(fecha, k -> new TreeMap<>((hora1, hora2) -> {
                HoraDia h1 = HoraDia.valueOf(hora1);
                HoraDia h2 = HoraDia.valueOf(hora2);
                return h1.ordinal() - h2.ordinal();
            })).computeIfAbsent(hora, k -> new ArrayList<>()).add(ausenciaDTO);
        }

        return historicoFaltas;
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
