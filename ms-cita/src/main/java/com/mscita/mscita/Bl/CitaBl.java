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
import java.util.Optional;

@Service
public class CitaBl {

    @Autowired
    private CitaRepository citaRepository;

    //Crear cita par aun paciente
    public void createCita(CitaDto citaDto, Integer idAsistente){
        TipoCita tipoCita = new TipoCita();
        Horario horario = new Horario();
        Cita cita = new Cita();
        tipoCita.setIdTipoCita(citaDto.getIdTipoCita());
        horario.setIdHorario(citaDto.getIdHorario());
        cita.setTipoCita(tipoCita);
        cita.setHorario(horario);
        cita.setIdPaciente(citaDto.getIdPaciente());
        cita.setIdAsistente(idAsistente);
        cita.setFecha(citaDto.getFecha());
        cita.setHora(citaDto.getHora());
        cita.setRazon(citaDto.getRazon());
        cita.setStatus(true);
        citaRepository.save(cita);
        System.out.println("Hora: " + citaDto.getHora());
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

    // Modificar la cita


    public void modificarCita(Integer citaId, CitaDto citaDto){
        Optional<Cita> optionalCita = citaRepository.findById(citaId);
        if(optionalCita.isPresent()){
            Cita cita = optionalCita.get();
            if (citaDto.getIdTipoCita() != null) {
                TipoCita tipoCita = new TipoCita();
                tipoCita.setIdTipoCita(citaDto.getIdTipoCita());
                cita.setTipoCita(tipoCita);
            }
            if (citaDto.getIdHorario() != null) {
                Horario horario = new Horario();
                horario.setIdHorario(citaDto.getIdHorario());
                cita.setHorario(horario);
            }
            cita.setIdAsistente(citaDto.getIdAsistente());
            cita.setFecha(citaDto.getFecha());
            cita.setHora(citaDto.getHora());
            cita.setRazon(citaDto.getRazon());
            cita.setStatus(citaDto.getEstado());
            citaRepository.save(cita);
        }else{
            throw new RuntimeException("La cita con ID "+ citaId + "no existe");
        }
    }
    // Boorado logico por cita
    public void borrarCita(Integer citaId){
        Optional<Cita> optionalCita = citaRepository.findById(citaId);
        if (optionalCita.isPresent()) {
            Cita cita = optionalCita.get();
            cita.setStatus(false);
            citaRepository.save(cita);
        }else{
            throw new RuntimeException("La cita con ID "+ citaId +" no existe");
        }
    }
}
