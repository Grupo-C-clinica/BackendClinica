package com.mscita.mscita.Entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.util.Timer;

@Entity
@Table(name = "HORARIO")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HORARIO")
    private Integer idHorario;

    @Column(name = "DOCTOR_ID_DOCTOR", nullable = false)
    private Integer doctorIdDoctor;

    @Column(name = "DIAS", nullable = false)
    private String dias;

    @Column(name = "HORA_INICIO", nullable = false)
    private String horaInicio;

    @Column(name = "HORA_FINAL", nullable = false)
    private String horaFin;

    @Column(name = "DISPONIBILIDAD", nullable = false)
    private Boolean disponibilidad;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public Horario() {
    }

    public Horario(Integer idHorario, Integer doctorIdDoctor, String dias, String horaInicio, String horaFin, Boolean disponibilidad, Boolean status) {
        this.idHorario = idHorario;
        this.doctorIdDoctor = doctorIdDoctor;
        this.dias = dias;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidad = disponibilidad;
        this.status = status;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getDoctorIdDoctor() {
        return doctorIdDoctor;
    }

    public void setDoctorIdDoctor(Integer doctorIdDoctor) {
        this.doctorIdDoctor = doctorIdDoctor;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", doctorIdDoctor=" + doctorIdDoctor +
                ", dias='" + dias + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", status=" + status +
                '}';
    }
}
