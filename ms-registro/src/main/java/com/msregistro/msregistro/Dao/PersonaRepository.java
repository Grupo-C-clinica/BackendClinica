package com.msregistro.msregistro.Dao;

import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Entity.Persona;
import com.msregistro.msregistro.Entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query(value = "SELECT * FROM PERSONA p WHERE p.ID_PERSONA IN (SELECT ID_PERSONA FROM PACIENTE)", nativeQuery = true)
    Page<Persona> findAllPacientes(Pageable pageable);

    //Mostrar todos los pacientes ordenados por nombre de forma asecendente o descendente
    @Query("SELECT p FROM Persona p WHERE p.idPersona IN (SELECT pa.persona.idPersona FROM Paciente pa) ORDER BY p.nombre ASC")
    Page<Persona> findAllPacientesOrderByNombreAsc(Pageable pageable);
    //
    @Query("SELECT p FROM Persona p WHERE p.idPersona IN (SELECT pa.persona.idPersona FROM Paciente pa) ORDER BY p.nombre DESC")
    Page<Persona> findAllPacientesOrderByNombreDesc(Pageable pageable);

    @Query("SELECT new com.msregistro.msregistro.Dto.PacienteViewDto(" +
            "p.idPersona, p.nombre, p.apellidoP, p.apellidoM, p.fechaNacimiento, p.genero) " +
            "FROM Persona p WHERE p.idPersona IN (SELECT pa.persona.idPersona FROM Paciente pa)")
    List<PacienteViewDto> findAllPaciente();
}