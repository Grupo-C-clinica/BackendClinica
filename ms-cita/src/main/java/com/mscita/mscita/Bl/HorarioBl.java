package com.mscita.mscita.Bl;

import com.mscita.mscita.Dto.HorarioDto;
import com.mscita.mscita.Entity.Horario;
import com.mscita.mscita.Repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioBl {

    @Autowired
    private HorarioRepository horarioRepository;

    //Mostrar todos los horarios disponibles
    public List<HorarioDto> findAllHorarios(){
        List<Horario> horario = horarioRepository.findAllHorarios();
        List<HorarioDto> horarioDto = new ArrayList<>();
        for (Horario horarios : horario){
            HorarioDto horarioDtos = new HorarioDto();
            horarioDtos.setIdHorario(horarios.getIdHorario());
            horarioDtos.setHoraInicio(horarios.getHoraInicio());
            horarioDtos.setHoraFin(horarios.getHoraFin());
            horarioDtos.setDisponibilidad(horarios.getDisponibilidad());
            horarioDtos.setStatus(horarios.getStatus());
            horarioDto.add(horarioDtos);
        }
        return horarioDto;
    }


}
