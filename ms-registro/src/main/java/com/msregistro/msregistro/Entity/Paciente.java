package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PACIENTE")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PACIENTE")
    private Integer idPaciente;

    @Column(name = "ID_ZONA")
    private Integer idZona;

    @Column(name = "ID_PERSONA")
    private Integer idPersona;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "TIPO_SANGRE")
    private String tipoSangre;

    @Column(name = "STATUS")
    private Boolean status;

    public Paciente() {
    }

    public Paciente(Integer idPaciente, Integer idZona, Integer idPersona, String correo, String tipoSangre, Boolean status) {
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
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", idZona=" + idZona +
                ", idPersona=" + idPersona +
                ", correo='" + correo + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", status=" + status +
                '}';
    }
}