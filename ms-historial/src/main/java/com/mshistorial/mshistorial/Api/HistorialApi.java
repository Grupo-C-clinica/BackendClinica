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
public class HistorialApi {
    @Autowired
    private HistorialBl hsitorialBl;

    //Mostrar historiales de un paciente
    @GetMapping(path = "/paciente/{idPaciente}")
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

    // Crear historial por paciente
    @PostMapping(path = "/agregar/{idPaciente}")
    public ResponseEntity<ResponseDto<String>> crearHistorialByPaciente (@PathVariable Integer idPaciente, @RequestBody HistorialDto historialDto){
        System.out.println("API received historialDto: " + historialDto); // Añadir para ver qué recibes exactamente

        try {
            hsitorialBl.addHistorialByPaciente(historialDto, idPaciente);
            return ResponseEntity.ok(new ResponseDto<>(200, "Historial creado con exito", null));
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al crear el historial"));
        }
    }

    // Obtener historial mediante su ID
    @GetMapping("/{idHistorial}")
    public ResponseEntity<ResponseDto<HistorialDto>> obtenerHistorialById (@PathVariable Integer idHistorial){
        try {
            HistorialDto historialDto = hsitorialBl.obtnerHistorialById(idHistorial);
            return ResponseEntity.ok(new ResponseDto<>(200, historialDto, "Historial encontrado"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.ok(new ResponseDto<>(404, null, e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al obtener el historial"));
        }
    }
}
