package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    /*Mostrar datos iniciales en lista de pacientes
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(pa.idPaciente, p.nombre, p.apellidoP, p.apellidoM, p.fechaNacimiento, p.genero) FROM Paciente pa JOIN Persona p Where pa.idPersona.idPersona = p.idPersona")
    public List<PacienteViewDto> findAllPacientes();
    */


}
