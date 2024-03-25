package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.PacienteBl;
import com.msregistro.msregistro.Bl.PersonaBl;
import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.PersonaDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
