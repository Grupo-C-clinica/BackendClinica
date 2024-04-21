package com.mscita.mscita.Dto;

public class HorarioDto {

    private Integer idHorario;
    private Integer doctorIdDoctor;
    private String dia;
    private String horaInicio;
    private String horaFin;
    private Boolean disponibilidad;
    private Boolean status;

    public HorarioDto() {
    }

    public HorarioDto(Integer idHorario, Integer doctorIdDoctor, String dia, String horaInicio, String horaFin, Boolean disponibilidad, Boolean status) {
        this.idHorario = idHorario;
        this.doctorIdDoctor = doctorIdDoctor;
        this.dia = dia;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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
        return "HorarioDto{" +
                "idHorario=" + idHorario +
                ", doctorIdDoctor=" + doctorIdDoctor +
                ", dia='" + dia + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", horaFin='" + horaFin + '\'' +
                ", disponibilidad=" + disponibilidad +
                ", status=" + status +
                '}';
    }
}
