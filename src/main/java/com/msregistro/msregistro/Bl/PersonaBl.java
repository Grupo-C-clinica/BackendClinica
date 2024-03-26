package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dao.PersonaRepository;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaBl {
    @Autowired
    private PersonaRepository personaRepository;

    //Mostrar lista de personas que son pacientes
    public List<PersonaDto> findPeronasPacientes(){
        List<Persona> personas = personaRepository.findAllPacientes();
        List<PersonaDto> personasDto =  new ArrayList<>();
        for (Persona persona : personas) {
            personasDto.add(new PersonaDto(persona.getIdPersona(), persona.getNombre(), persona.getApellidoP(),persona.getApellidoM(), persona.getFechaNacimiento(), persona.getGenero(), persona.getTelefono(), persona.getCi(), persona.getStatus()));
        }
        return personasDto;
    }

}
