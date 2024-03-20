package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Entity.Paciente;
import com.msregistro.msregistro.Entity.Persona;
import com.msregistro.msregistro.Entity.Zona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.msregistro.msregistro.Dao.PacienteRepository;
import com.msregistro.msregistro.Dao.PersonaRepository;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class PacienteBl {
    @Autowired

    private PacienteRepository pacienteRepository;
    private PersonaRepository personaRepository;

    //Agregar paciente
    public void addPaciente(PacienteDto nuevoPaciente) throws Exception {
        try {
            Persona persona = new Persona();
            persona.setNombre(nuevoPaciente.getNombre());
            persona.setApellidoP(nuevoPaciente.getApellidoP());
            persona.setApellidoM(nuevoPaciente.getApellidoM());
            persona.setFechaNacimiento(String.valueOf(new Date()));
            persona.setGenero(nuevoPaciente.getGenero());
            persona.setStatus(true);
            personaRepository.save(persona);
            Paciente paciente = new Paciente();
            paciente.setIdPersona(persona.getIdPersona());
            paciente.setIdZona(nuevoPaciente.getIdZona());
            paciente.setCorreo(nuevoPaciente.getCorreo());
            paciente.setTipoSangre(nuevoPaciente.getTipoSangre());
            paciente.setStatus(true);
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            throw new Exception("Error al agregar paciente");
        }
    }
}
