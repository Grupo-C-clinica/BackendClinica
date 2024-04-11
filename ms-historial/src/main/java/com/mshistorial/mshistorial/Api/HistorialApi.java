package com.mshistorial.mshistorial.Api;

import com.mshistorial.mshistorial.Bl.HistorialBl;
import com.mshistorial.mshistorial.Dto.HistorialDto;
import com.mshistorial.mshistorial.Dto.ResponseDto;
import com.mshistorial.mshistorial.Entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historial")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HistorialApi {
    @Autowired
    private HistorialBl hsitorialBl;

    //Mostrar historiales de un paciente
    @GetMapping(path = "/{idPaciente}")
    public ResponseEntity<ResponseDto<List<HistorialDto>>> findHistorialByPaciente(@PathVariable Integer idPaciente){
        List<HistorialDto> historiales = hsitorialBl.listaHistorialByPaciente(idPaciente);
        try{
            if(historiales != null){
                return ResponseEntity.ok(new ResponseDto<>(200, historiales, "Historiales del paciente encontrados"));
            }else{
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron historiales del paciente"));
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al encontrar historiales"));
        }
    }
}
