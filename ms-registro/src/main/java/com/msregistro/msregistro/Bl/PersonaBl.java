package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dao.PersonaRepository;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

}
