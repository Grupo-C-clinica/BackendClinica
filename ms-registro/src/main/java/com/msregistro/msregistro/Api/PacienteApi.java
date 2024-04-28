package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.PacienteBl;
import com.msregistro.msregistro.Bl.PersonaBl;
import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.PacienteViewDto;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/api/v1/paciente")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PacienteApi {
    @Autowired
    private PacienteBl pacienteBl;

    @Autowired
    private PersonaBl personaBl;

    @PostMapping(path = "/agregar")
    public ResponseEntity<ResponseDto<String>> addPaciente(@RequestBody PacienteDto nuevoPaciente)  {
        try{
            pacienteBl.addPaciente(nuevoPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Paciente agregado"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar paciente"));
        }
    }

    //Mostrar datos de persona de pacientes

    @GetMapping(path = "/all")
    public ResponseEntity<ResponseDto<Page<PersonaDto>>> findPacientes(
            @PageableDefault(page = 0, size = 10) Pageable pageable)
    {try {
            Page<PersonaDto> pacientes = personaBl.findPeronasPacientes(pageable);
            if (!pacientes.isEmpty()) {
                return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron pacientes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al mostrar pacientes"));
        }
    }

    //Mostrar pacientes por nombre
    @GetMapping(path = "/nombre")
    public ResponseEntity<ResponseDto<List<PacienteViewDto>>> findPacientesByName(@RequestParam String nombre) {
        List<PacienteViewDto> pacientes = pacienteBl.findPacientesByName(nombre);
        if (pacientes == null) {
            pacientes = new ArrayList<>();  // Asegura devolver una lista vacía en lugar de null
        }
        return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
    }


    //Mostrar pacientes por fecha de nacimiento
    @GetMapping(path = "/fecha/{fechaNacimiento}")
    public ResponseEntity<ResponseDto<List<PacienteViewDto>>> findPacientesByFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaNacimiento) {
        List<PacienteViewDto> pacientes = pacienteBl.findPacientesByFecha(fechaNacimiento);
        try {
            if (pacientes != null) {
                return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron pacientes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al mostrar pacientes"));
        }
    }




    @GetMapping(path = "/estado/{estado}")
    public ResponseEntity<ResponseDto<Page<PacienteViewDto>>> findPacientesByStatus(@PathVariable Boolean estado, @PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<PacienteViewDto> pacientes = pacienteBl.findPacientesByStatus(estado, pageable);
            if (pacientes != null && !pacientes.isEmpty()) {
                return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, Page.empty(), "No se encontraron pacientes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al mostrar pacientes"));
        }
    }

    //modificar un paciente
    @PutMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<String>> updatePaciente(@RequestBody PacienteDto pacienteDto, @PathVariable Integer idPaciente) {
        try {
            pacienteBl.updatePaciente(pacienteDto, idPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Paciente modificado"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al modificar paciente"));
        }
    }

    //Mostrar los pacientes por orden ascendente o descendente
    @GetMapping(path = "/ordenar/{orden}")
    public ResponseEntity<ResponseDto<Page<PersonaDto>>> findPacientesOrderByNombre(@PathVariable Integer orden, @PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<PersonaDto> pacientes = personaBl.findAllPacientesOrderByNombreAscOrDesc(pageable, orden);
            if (!pacientes.isEmpty()) {
                return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron pacientes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al mostrar pacientes"));
        }
    }







}
