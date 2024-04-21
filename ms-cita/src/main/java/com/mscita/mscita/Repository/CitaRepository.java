package com.mscita.mscita.Repository;

import com.mscita.mscita.Entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    //Ver todas las citas de un paciente por fecha
    @Query("SELECT c FROM Cita c WHERE c.idPaciente= ?1 And c.fecha= ?2")
    public List<Cita> findAllByPatientId(Integer patientId);

    //Ver todas las citas de un doctor por fecha
    @Query("SELECT c FROM Cita c WHERE c.horario.doctorIdDoctor= ?1 And c.fecha= ?2")
    public List<Cita> findAllByDoctorId(Integer doctorId, Date fechaCita);

    //Ver todas las citas de un horario y su fecha de cita
    @Query("SELECT c FROM Cita c WHERE c.horario.idHorario= ?1 And c.fecha= ?2")
    public List<Cita> findAllByHorarioIdAndFechaCita(Integer horarioId, Date fechaCita);

    //Ver todas las citas de un asistente
    @Query("SELECT c FROM Cita c WHERE c.idAsistente= ?1")
    public List<Cita> findAllByAssistantId(Integer assistantId);

    //Ver todas las citas de un tipo de cita por fecha
    @Query("SELECT c FROM Cita c WHERE c.tipoCita.idTipoCita= ?1 And c.fecha= ?2")
    public List<Cita> findAllByTypeCitaId(Integer typeCitaId, Date fechaCita);

    //Ver todas las citas de un paciente entre dos fechas
    @Query("SELECT c FROM Cita c WHERE c.idPaciente= ?1 And c.fecha BETWEEN ?2 AND ?3")
    public List<Cita> findAllByPatientIdBetweenDates(Integer patientId, Date fechaInicio, Date fechaFin);
}
