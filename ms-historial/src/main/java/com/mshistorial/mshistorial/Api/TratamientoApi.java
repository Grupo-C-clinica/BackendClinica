package com.mshistorial.mshistorial.Api;

import com.mshistorial.mshistorial.Bl.TratamientoBl;
import com.mshistorial.mshistorial.Dto.ResponseDto;
import com.mshistorial.mshistorial.Dto.TratamientoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tratamiento")
public class TratamientoApi {
    @Autowired
    private TratamientoBl tratamientoBl;

    //Mostrar Tratamiento por historial
    @GetMapping(path = "/historial/{idHistorial}")
    public ResponseEntity<ResponseDto<List<TratamientoDto>>> findTratamientoByHistorial(@PathVariable Integer idHistorial){
        List<TratamientoDto> tratamientos = tratamientoBl.listaTratamientoByHistorial(idHistorial);
        try{
            if (tratamientos != null){
                return ResponseEntity.ok(new ResponseDto<>(200, tratamientos, "Tratamientos encontrados"));
            }else{
                return ResponseEntity.ok(new ResponseDto<>(200, null, "No se encontraron tratamientos"));
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al encontrar tratamientos"));
        }
    }

    //Crear Tratamiento por Historial
    @PostMapping(path = "/agregar/{idHistorial}")
    public ResponseEntity<ResponseDto<String>> crearTratamientoByHistorial(@PathVariable Integer idHistorial, @RequestBody TratamientoDto tratamientoDto){
        try{
            tratamientoBl.addTratamientoByHistorial(tratamientoDto, idHistorial);
            return ResponseEntity.ok(new ResponseDto<>(200, "Tratamiento creado con exito", null));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al crear el tratamiento"));
        }
    }

    //Obtener Tratamiento por su ID
    @GetMapping("/{idTratamiento}")
    public ResponseEntity<ResponseDto<TratamientoDto>> obtenerTratamientoById (@PathVariable Integer idTratamiento){
        try {
            TratamientoDto tratamientoDto = tratamientoBl.obtenerTratamientoById(idTratamiento);
            return ResponseEntity.ok(new ResponseDto<>(200, tratamientoDto, "Tratamiento encontrado"));
        }catch (IllegalArgumentException e){
            return ResponseEntity.ok(new ResponseDto<>(404, null, e.getMessage()));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error al obtener el tratamiento"));
        }
    }
}
