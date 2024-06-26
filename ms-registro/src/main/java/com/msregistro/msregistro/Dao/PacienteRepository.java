package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface PacienteRepository extends JpaRepository<Paciente,Integer> {

    /*Mostrar datos iniciales en lista de pacientes
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(pa.idPaciente, p.nombre, p.apellidoP, p.apellidoM, p.fechaNacimiento, p.genero) FROM Paciente pa JOIN Persona p Where pa.idPersona.idPersona = p.idPersona")
    public List<PacienteViewDto> findAllPacientes();
    */

    // Mostrar pacientes status true, buscar por nombre
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente, p.persona.nombre, p.persona.apellidoP, p.persona.apellidoM, p.persona.fechaNacimiento, p.persona.genero) " +
            "FROM Paciente p WHERE (LOWER(p.persona.nombre) LIKE LOWER(:nombre) OR " +
            "LOWER(p.persona.apellidoP) LIKE LOWER(:nombre) OR " +
            "LOWER(p.persona.apellidoM) LIKE LOWER(:nombre))")
    List<PacienteViewDto> findPacienteViewDtosByNombreAndStatusTrue(@Param("nombre") String nombre);
//AND p.status = true



    // Mostrar pacientes status true, buscar por fecha de nacimiento
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente,p.persona.nombre,p.persona.apellidoP,p.persona.apellidoM,p.persona.fechaNacimiento,p.persona.genero) " +
            "FROM Paciente p JOIN p.persona persona " +
            "WHERE persona.fechaNacimiento = :fechaNacimiento AND p.status = true")
    List<PacienteViewDto> findPacienteViewDtosByFechaNacimientoAndStatusTrue(@Param("fechaNacimiento") Date fechaNacimiento);



    // Mostrar pacientes por estado
    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(p.idPaciente, p.persona.nombre, p.persona.apellidoP, p.persona.apellidoM, p.persona.fechaNacimiento, p.persona.genero) " +
            "FROM Paciente p JOIN p.persona persona " +
            "WHERE p.status = :status")
    Page<PacienteViewDto> findPacienteViewDtosByStatus(@Param("status") Boolean status, Pageable pageable);

    // obtener id de persona por id paciente
    @Query("SELECT p.persona.idPersona FROM Paciente p WHERE p.idPaciente = ?1")
    Integer findIdPersonaByIdPaciente( Integer idPaciente);

}
