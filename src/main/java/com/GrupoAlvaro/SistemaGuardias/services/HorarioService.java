package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Horario;
import com.GrupoAlvaro.SistemaGuardias.repositories.HorarioRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.ProfesorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Transactional
    public void guardarHorario(Horario horario) {
        horarioRepository.save(horario);
    }


}
