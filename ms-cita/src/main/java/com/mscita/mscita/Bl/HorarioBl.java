package com.mscita.mscita.Bl;

import com.mscita.mscita.Dto.HorarioDto;
import com.mscita.mscita.Entity.Horario;
import com.mscita.mscita.Repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioBl {

    @Autowired
    private HorarioRepository horarioRepository;

    //Mostrar todos los horarios disponibles
    /*public Page<HorarioDto> findAllHorarios(Pageable pageable){
        Page<Horario> horario = horarioRepository.findAllHorarios(pageable);
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
    }*/
    public Page<HorarioDto> findAllHorarios(Pageable pageable){
        Page<Horario> horarioPage = horarioRepository.findAllHorarios(pageable);
        return horarioPage.map(horario -> {
            HorarioDto horarioDto = new HorarioDto();
            horarioDto.setIdHorario(horario.getIdHorario());
            horarioDto.setHoraInicio(horario.getHoraInicio());
            horarioDto.setHoraFin(horario.getHoraFin());
            horarioDto.setDisponibilidad(horario.getDisponibilidad());
            horarioDto.setStatus(horario.getStatus());
            return horarioDto;
        });
    }

    //Mostrar todos los horarios de un doctor
    public Page<HorarioDto> findAllHorariosByDoctorId(Integer doctorId, Pageable pageable){
        Page<Horario> horario = horarioRepository.findAllHorariosByDoctorId(doctorId, pageable);
        return horario.map(horario1 -> {
            HorarioDto horarioDto = new HorarioDto();
            horarioDto.setIdHorario(horario1.getIdHorario());
            horarioDto.setHoraInicio(horario1.getHoraInicio());
            horarioDto.setHoraFin(horario1.getHoraFin());
            horarioDto.setDisponibilidad(horario1.getDisponibilidad());
            horarioDto.setStatus(horario1.getStatus());
            return horarioDto;
        });
        /*List<HorarioDto> horarioDto = new ArrayList<>();
        for (Horario horarios : horario){
            HorarioDto horarioDtos = new HorarioDto();
            horarioDtos.setIdHorario(horarios.getIdHorario());
            horarioDtos.setHoraInicio(horarios.getHoraInicio());
            horarioDtos.setHoraFin(horarios.getHoraFin());
            horarioDtos.setDisponibilidad(horarios.getDisponibilidad());
            horarioDtos.setStatus(horarios.getStatus());
            horarioDto.add(horarioDtos);
        }
        return horarioDto;*/
    }

    //Crear un horario de un doctor
    public void createHorario(HorarioDto horarioDto, Integer doctorId){
        Horario horario = new Horario();
        horario.setDoctorIdDoctor(doctorId);
        horario.setDias(horarioDto.getDia());
        horario.setHoraInicio(horarioDto.getHoraInicio());
        horario.setHoraFin(horarioDto.getHoraFin());
        horario.setDisponibilidad(horarioDto.getDisponibilidad());
        horario.setStatus(true);
        horarioRepository.save(horario);
    }


}
