package com.msregistro.msregistro.Api;

import com.msregistro.msregistro.Bl.AntecedentesPatologicosBl;
import com.msregistro.msregistro.Dto.AntecedentesPatologicosDto;
import com.msregistro.msregistro.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/antecedentesPatologicos")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AntecedentesPatologicosApi {

    @Autowired
    private AntecedentesPatologicosBl antecedentesPatologicosBl;

    //Mostrar antecedentes patologicos de un paciente
    @GetMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<List<AntecedentesPatologicosDto>>> findAntecedentesPatologicosByPaciente(@PathVariable Integer idPaciente) {
        List<AntecedentesPatologicosDto> antecedentesPatologicos = antecedentesPatologicosBl.findAntecedentesPatologicosByPaciente(idPaciente);
        try {
            if (antecedentesPatologicos != null) {
                return ResponseEntity.ok(new ResponseDto<>(200, antecedentesPatologicos, "Antecedentes patologicos encontrados"));
            } else {
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron antecedentes patologicos"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al buscar antecedentes patologicos"));
        }
    }

    //Agregar antecedentes patologicos a un paciente
    @PostMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<String>> addAntecedentesPatologicosByPaciente(@RequestBody List<AntecedentesPatologicosDto> antecedentesPatologicos, @PathVariable Integer idPaciente) {
        try {
            antecedentesPatologicosBl.addAntecedentesPatologicosByPaciente(antecedentesPatologicos, idPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, null, "Antecedentes patologicos agregados"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al agregar antecedentes patologicos"));
        }
    }
}
