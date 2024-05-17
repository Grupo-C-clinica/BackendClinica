package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dao.PersonaRepository;
import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
public class PersonaBl {
    @Autowired
    private PersonaRepository personaRepository;

    public Page<PersonaDto> findPeronasPacientes(Pageable pageable){
        Page<Persona> pagePersonas = personaRepository.findAllPacientes(pageable);
        return pagePersonas.map(persona -> new PersonaDto(persona.getIdPersona(), persona.getNombre(), persona.getApellidoP(),persona.getApellidoM(), persona.getFechaNacimiento(), persona.getGenero(), persona.getTelefono(), persona.getCi(), persona.getStatus()));
    }

    //Mostrar todos los pacientes ordenados por nombre de forma asecendente o descendente
    public Page<PersonaDto> findAllPacientesOrderByNombreAscOrDesc(Pageable pageable, Integer status){
        Page <Persona> pagePersonas;
        if (status == 1)
            pagePersonas = personaRepository.findAllPacientesOrderByNombreAsc(pageable);
        else
            pagePersonas = personaRepository.findAllPacientesOrderByNombreDesc(pageable);
        return pagePersonas.map(persona -> new PersonaDto(persona.getIdPersona(), persona.getNombre(), persona.getApellidoP(),persona.getApellidoM(), persona.getFechaNacimiento(), persona.getGenero(), persona.getTelefono(), persona.getCi(), persona.getStatus()));
    }

    public List<PacienteViewDto> findAllPacientes() {
        List<PacienteViewDto> personas = personaRepository.findAllPaciente();
        return personas.stream()
                .map(persona -> new PacienteViewDto(
                        persona.getIdPaciente(),
                        persona.getNombre(),
                        persona.getApellidoP(),
                        persona.getApellidoM(),
                        persona.getFechaNacimiento(),
                        persona.getGenero()))
                .collect(Collectors.toList());
    }
}
