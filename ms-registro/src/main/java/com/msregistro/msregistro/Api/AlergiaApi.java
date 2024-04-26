package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.AlergiaBl;
import com.msregistro.msregistro.Dto.AlergiaDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alergia")
//@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlergiaApi {
    @Autowired
    private AlergiaBl alergiaBl;

    //Mostrar alergias de un paciente
    @GetMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<List<AlergiaDto>>> findAlergiasByPaciente(@PathVariable Integer idPaciente) {
        List<AlergiaDto> alergias = alergiaBl.findAlergiasByPaciente(idPaciente);
        try {
            if (alergias != null) {
                return ResponseEntity.ok(new ResponseDto<>(200, alergias, "Alergias encontradas"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron alergias"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al buscar alergias"));
        }
    }

    //Agregar alergias a un paciente
    @PostMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<String>> addAlergiaByPaciente(@RequestBody List<AlergiaDto> alergias, @PathVariable Integer idPaciente) {
        try {
            alergiaBl.addAlergiaByPaciente(alergias, idPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Alergias agregadas"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar alergias"));
        }
    }
}
