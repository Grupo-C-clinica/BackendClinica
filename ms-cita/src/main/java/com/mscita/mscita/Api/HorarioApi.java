package com.mscita.mscita.Api;

import com.mscita.mscita.Bl.HorarioBl;
import com.mscita.mscita.Dto.HorarioDto;
import com.mscita.mscita.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/horario")
@CrossOrigin(origins = "*", methods= {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE})
public class HorarioApi {

    @Autowired
    private HorarioBl horarioBl;

    //Mostrar todos los horarios disponibles
    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<HorarioDto>>> findAllHorarios(){
        List<HorarioDto> horarioDtos = horarioBl.findAllHorarios();
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, horarioDtos, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }

    }

    //Crear un horario de un doctor
    @PostMapping("/create/{doctorId}")
    public ResponseEntity<ResponseDto<String>> createHorario(@RequestBody HorarioDto horarioDto, @PathVariable Integer doctorId){
        horarioBl.createHorario(horarioDto, doctorId);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, "Horario creado correctamente", "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }



}
