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

@RestController
@RequestMapping("/api/v1/paciente")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
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
    public ResponseEntity<ResponseDto<List<PersonaDto>>> findPacientes() {
        List<PersonaDto> pacientes = personaBl.findPeronasPacientes();
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

    //Mostrar pacientes por nombre
    @GetMapping
    public ResponseEntity<ResponseDto<List<PacienteViewDto>>> findPacientesByName(@RequestParam String nombre) {
        List<PacienteViewDto> pacientes = pacienteBl.findPacientesByName(nombre);
        try {
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


    //Mostrar pacientes por fecha de nacimiento
    @GetMapping(path = "/fecha/{fechaNacimiento}")
    public ResponseEntity<ResponseDto<List<PacienteViewDto>>> findPacientesByFecha(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date fechaNacimiento) {
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
    public ResponseEntity<ResponseDto<List<PacienteViewDto>>> findPacientesByStatus(@PathVariable Boolean estado) {
        try {
            List<PacienteViewDto> pacientes = pacienteBl.findPacientesByStatus(estado);
            if (pacientes != null && !pacientes.isEmpty()) {
                return ResponseEntity.ok(new ResponseDto<>(200, pacientes, "Pacientes encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, new ArrayList<>(), "No se encontraron pacientes"));
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



    


}
