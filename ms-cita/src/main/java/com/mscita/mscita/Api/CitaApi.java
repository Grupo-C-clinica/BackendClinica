package com.mscita.mscita.Api;

import com.mscita.mscita.Bl.CitaBl;
import com.mscita.mscita.Dto.CitaDto;
import com.mscita.mscita.Dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/cita")
@CrossOrigin(origins = "*", methods= {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE})
public class CitaApi {

    @Autowired
    private CitaBl citaBl;

    //Crear cita para un paciente
    @PostMapping("/create/{pacienteId}")
    public ResponseEntity<ResponseDto<CitaDto>> createCita(@PathVariable Integer pacienteId, @RequestBody CitaDto citaDto){
        citaBl.createCita(citaDto, pacienteId);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    //Ver todas las citas del paciente por su fecha
    @GetMapping("/all/{pacienteId}/{fechaCita}")
    public ResponseEntity<ResponseDto<List<CitaDto>>> findAllByPatientIdAndDate(@PathVariable Integer pacienteId, @PathVariable Date fechaCita){
        List<CitaDto> citaDtos = citaBl.findAllByPatientIdAndDate(pacienteId, fechaCita);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citaDtos, "Success"));
        } catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    @GetMapping("/allDates")
    public ResponseEntity<ResponseDto<List<CitaDto>>> findAllByDateRange (@PathVariable Date fechaInicio, @PathVariable Date fechaFinal){
        List<CitaDto> citasDto = citaBl.findAllByDateRange(fechaInicio, fechaFinal);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citasDto, "Succes"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseDto<List<CitaDto>>> findAllByDate(@PathVariable Date fecha){
        List<CitaDto> citaDto = citaBl.findAllByDate(fecha);
        try {
            return ResponseEntity.ok(new ResponseDto<>(200, citaDto, "Succes"));
        }catch (Exception e){
            return ResponseEntity.ok(new ResponseDto<>(500, null, "Error"));
        }
    }
}
