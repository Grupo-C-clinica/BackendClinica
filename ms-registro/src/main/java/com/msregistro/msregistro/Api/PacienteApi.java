package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.PacienteBl;
import com.msregistro.msregistro.Dto.PacienteDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/paciente")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class PacienteApi {
    @Autowired
    private PacienteBl pacienteBl;

    @PostMapping(path = "/agregar")
    public ResponseEntity<ResponseDto<String>> addPaciente(@RequestBody PacienteDto nuevoPaciente) throws Exception {
        try{
            pacienteBl.addPaciente(nuevoPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Paciente agregado"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar paciente"));
        }
    }
}
