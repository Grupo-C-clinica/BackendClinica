package com.mshistorial.mshistorial.Service;

import com.mshistorial.mshistorial.Dto.PacienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(name = "ms-registro")
public interface HistorialService {
    //TODO LO DE PACIENTE
    @GetMapping("/api/v1/paciente/getPacienteById/{idPaciente}")
    PacienteDto obtenerPaciente(@PathVariable Integer idPaciente);

    //TODO LO DE PERSONA
}
