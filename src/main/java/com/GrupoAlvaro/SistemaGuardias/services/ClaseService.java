package com.GrupoAlvaro.SistemaGuardias.services;

import com.GrupoAlvaro.SistemaGuardias.models.Clase;
import com.GrupoAlvaro.SistemaGuardias.repositories.ClaseRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.GrupoRepository;
import com.GrupoAlvaro.SistemaGuardias.repositories.HorarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {
@Autowired
    private ClaseRepository claseRepository;
@Autowired
    private ProfesorRepository  profesorRepository;
@Autowired
    private GrupoRepository grupoRepository;
@Autowired
    private HorarioRepository horarioRepository;
@Autowired
    private AsignaturaRepository asignaturaRepository;

//Operaciones Crud
//Metodo para crear una clase
@Transactional
    public Clase crearClase(Clase clase) {return claseRepository.save(clase);}

    //Metodo para eliminar una clase
@Transactional
public void eliminarClase(Long id) {
    Optional<Clase> clase = claseRepository.findById(id);
    if (clase.isPresent()) {
        System.out.println("Eliminando la clase con id: " + id);
        claseRepository.deleteById(id);
    } else {
        System.out.println("La clase con esta id"+id +" o existe");
    }
}


//Metodos para mostrar cosas
    //Metodo para mostrar todas las clases
        @Transactional
        public List<Clase> mostrarClases() {return claseRepository.findAll();}

    //Metodo para mostra la clas con id especifica
    @Transactional
    public Clase mostrarClasePorId(Long id) {
        return claseRepository.findById(id).orElseThrow(() -> new RuntimeException("Clase no encontrada con el ID: " + id));
    }

//Metodo para actualizar la clase
@Transactional
public Clase modificarClase(Long id, Clase claseActualizada) {
    Clase clase = claseRepository.findById(id).orElseThrow(() -> new RuntimeException("Clase no encontrada con el ID: " + id));

    clase.setDiaSemana(claseActualizada.getDiaSemana());
    clase.setHora(claseActualizada.getHora());
    clase.setProfesor(claseActualizada.getProfesor());
    clase.setGrupo(claseActualizada.getGrupo());
    clase.setAsignatura(claseActualizada.getAsignatura());
    clase.setHorario(claseActualizada.getHorario());

    return claseRepository.save(clase);
}

}
