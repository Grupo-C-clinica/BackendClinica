package com.msregistro.msregistro.Dto;

import java.util.Date;

public class PacienteDto {
    private Integer idPaciente;
    private Integer idZona;
    private Integer idPersona;
    private String correo;
    private String tipoSangre;
    private Boolean status;

    public PacienteDto() {
    }

    public PacienteDto(Integer idPaciente, Integer idZona, Integer idPersona, String correo, String tipoSangre, Boolean status) {
        this.idPaciente = idPaciente;
        this.idZona = idZona;
        this.idPersona = idPersona;
        this.correo = correo;
        this.tipoSangre = tipoSangre;
        this.status = status;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "PacienteDto{" +
                "idPaciente=" + idPaciente +
                ", idZona=" + idZona +
                ", idPersona=" + idPersona +
                ", correo='" + correo + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", status=" + status +
                '}';
    }
}
