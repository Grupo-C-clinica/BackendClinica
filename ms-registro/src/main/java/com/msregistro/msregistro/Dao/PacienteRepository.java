package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    /*Mostrar datos iniciales en lista de pacientes
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(pa.idPaciente, p.nombre, p.apellidoP, p.apellidoM, p.fechaNacimiento, p.genero) FROM Paciente pa JOIN Persona p Where pa.idPersona.idPersona = p.idPersona")
    public List<PacienteViewDto> findAllPacientes();
    */

    // Mostrar pacientes status true, buscar por nombre
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente,p.persona.nombre,p.persona.apellidoP,p.persona.apellidoM,p.persona.fechaNacimiento,p.persona.genero) " +
            "FROM Paciente p JOIN p.persona persona " +
            "WHERE LOWER(persona.nombre) LIKE %:nombre% AND p.status = true")
    List<PacienteViewDto> findPacienteViewDtosByNombreAndStatusTrue(@Param("nombre") String nombre);


    // Mostrar pacientes status true, buscar por fecha de nacimiento
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente,p.persona.nombre,p.persona.apellidoP,p.persona.apellidoM,p.persona.fechaNacimiento,p.persona.genero) " +
            "FROM Paciente p JOIN p.persona persona " +
            "WHERE persona.fechaNacimiento = :fechaNacimiento AND p.status = true")
    List<PacienteViewDto> findPacienteViewDtosByFechaNacimientoAndStatusTrue(@Param("fechaNacimiento") Date fechaNacimiento);



    // Mostrar pacientes por estado
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente,p.persona.nombre,p.persona.apellidoP,p.persona.apellidoM,p.persona.fechaNacimiento,p.persona.genero) " +
            "FROM Paciente p JOIN p.persona persona " +
            "WHERE p.status = :status")
    List<PacienteViewDto> findPacienteViewDtosByStatus(@Param("status") Boolean status);


}
