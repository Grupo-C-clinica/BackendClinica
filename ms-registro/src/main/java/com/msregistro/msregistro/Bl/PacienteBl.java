package com.msregistro.msregistro.Bl;

import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.PacienteViewDto;
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
import java.util.List;

@Service
public class PacienteBl {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PersonaRepository personaRepository;

    //Agregar paciente
    public void addPaciente(PacienteDto nuevoPaciente)  {
        System.out.println("Paciente: " + nuevoPaciente);
        try {
            Persona persona = new Persona();
            persona.setNombre(nuevoPaciente.getNombre());
            persona.setApellidoP(nuevoPaciente.getApellidoP());
            persona.setApellidoM(nuevoPaciente.getApellidoM());
            persona.setFechaNacimiento(nuevoPaciente.getFechaNacimiento());
            persona.setGenero(nuevoPaciente.getGenero());
            persona.setTelefono(nuevoPaciente.getTelefono());
            persona.setCi(nuevoPaciente.getCi());
            persona.setStatus(true);
            personaRepository.save(persona);

            Paciente paciente = new Paciente();
            paciente.setPersona(persona);
            paciente.setIdZona(nuevoPaciente.getIdZona());
            paciente.setCorreo(nuevoPaciente.getCorreo());
            paciente.setTipoSangre(nuevoPaciente.getTipoSangre());
            paciente.setStatus(true);
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Obtener lista de pacientes por nombre
    public List<PacienteViewDto> findPacientesByName(String nombre) {
        List<PacienteViewDto> pacientes = pacienteRepository.findPacienteViewDtosByNombreAndStatusTrue(nombre);
        return pacientes;
    }

    // Obtener lista de pacientes por fecha de nacimiento
    public List<PacienteViewDto> findPacientesByFecha(String fechaNacimiento) {
        List<PacienteViewDto> pacientes = pacienteRepository.findPacienteViewDtosByFechaNacimientoAndStatusTrue(fechaNacimiento);
        return pacientes;
    }

    //Obtener lista de pacientes por estado
    public List<PacienteViewDto> findPacientesByStatus(Boolean status) {
        List<PacienteViewDto> pacientes = pacienteRepository.findPacienteViewDtosByStatus(status);
        return pacientes;
    }
}
