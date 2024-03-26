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
import org.springframework.transaction.annotation.Transactional;
@Service
public class PacienteBl {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PersonaRepository personaRepository;

    //Agregar paciente
    @Transactional
    public void addPaciente(PacienteDto nuevoPaciente) {
        try {
            // Crear y guardar la entidad Persona
            Persona persona = new Persona();
            persona.setNombre(nuevoPaciente.getNombre());
            persona.setApellidoP(nuevoPaciente.getApellidoP());
            persona.setApellidoM(nuevoPaciente.getApellidoM());
            persona.setFechaNacimiento(nuevoPaciente.getFechaNacimiento());
            persona.setGenero(nuevoPaciente.getGenero());
            persona.setTelefono(nuevoPaciente.getTelefono());
            persona.setCi(nuevoPaciente.getCi());
            persona.setStatus(nuevoPaciente.getStatus());
            persona = personaRepository.save(persona);

            // Crear y guardar la entidad Paciente asociada con la Persona guardada
            Paciente paciente = new Paciente();
            paciente.setIdPersona(persona); // Asociar Persona
            paciente.setIdZona(nuevoPaciente.getIdZona());
            paciente.setCorreo(nuevoPaciente.getCorreo());
            paciente.setTipoSangre(nuevoPaciente.getTipoSangre());
            paciente.setStatus(nuevoPaciente.getStatus());
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al agregar paciente", e);
        }
    }
}
