package com.mscita.mscita.Bl;

import com.mscita.mscita.Dto.CitaDto;
import com.mscita.mscita.Entity.Cita;
import com.mscita.mscita.Entity.Horario;
import com.mscita.mscita.Entity.TipoCita;
import com.mscita.mscita.Repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CitaBl {

    @Autowired
    private CitaRepository citaRepository;

    //Crear cita par aun paciente
    public void createCita(CitaDto citaDto, Integer idPaciente){
        TipoCita tipoCita = new TipoCita();
        Horario horario = new Horario();
        Cita cita = new Cita();
        tipoCita.setIdTipoCita(citaDto.getIdTipoCita());
        horario.setIdHorario(citaDto.getIdHorario());
        cita.setTipoCita(tipoCita);
        cita.setHorario(horario);
        cita.setIdPaciente(idPaciente);
        cita.setIdAsistente(citaDto.getIdAsistente());
        cita.setFecha(citaDto.getFecha());
        cita.setHora(citaDto.getHora());
        cita.setRazon(citaDto.getRazon());
        cita.setStatus(true);
        citaRepository.save(cita);
    }

    //Ver todas las citas de un paciente por su fecha
    public List<CitaDto> findAllByPatientIdAndDate(Integer patientId, Date fechaCita){
        List<Cita> cita = citaRepository.findAllByPatientId(patientId, fechaCita);
        List<CitaDto> citaDto = new ArrayList<>();
        for (Cita citas : cita){
            CitaDto citaDtos = new CitaDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdTipoCita(citas.getTipoCita().getIdTipoCita());
            citaDtos.setIdHorario(citas.getHorario().getIdHorario());
            citaDtos.setIdPaciente(citas.getIdPaciente());
            citaDtos.setIdAsistente(citas.getIdAsistente());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setRazon(citas.getRazon());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }

    public List<CitaDto> findAllByDateRange (Date fechaInicio, Date fechaFin){
        List<Cita> cita = citaRepository.findAllBetweenDates(fechaInicio, fechaFin);
        List<CitaDto> citaDto = new ArrayList<>();
        for (Cita citas: cita){
            CitaDto citaDtos = new CitaDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdTipoCita(citas.getTipoCita().getIdTipoCita());
            citaDtos.setIdHorario(citas.getHorario().getIdHorario());
            citaDtos.setIdPaciente(citas.getIdPaciente());
            citaDtos.setIdAsistente(citas.getIdAsistente());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setRazon(citas.getRazon());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }

    public List<CitaDto> findAllByDate (Date fecha){
        List<Cita> cita = citaRepository.findAllCitasByFecha(fecha);
        List<CitaDto> citaDto = new ArrayList<>();
        for(Cita citas: cita){
            CitaDto citaDtos = new CitaDto();
            citaDtos.setIdCita(citas.getIdCita());
            citaDtos.setIdTipoCita(citas.getTipoCita().getIdTipoCita());
            citaDtos.setIdHorario(citas.getHorario().getIdHorario());
            citaDtos.setIdPaciente(citas.getIdPaciente());
            citaDtos.setIdAsistente(citas.getIdAsistente());
            citaDtos.setFecha(citas.getFecha());
            citaDtos.setHora(citas.getHora());
            citaDtos.setRazon(citas.getRazon());
            citaDtos.setEstado(citas.getStatus());
            citaDto.add(citaDtos);
        }
        return citaDto;
    }
}
