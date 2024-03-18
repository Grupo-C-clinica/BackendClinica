package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Integer idPaciente;

    @Column(name = "id_zona")
    private Integer idZona;

    @Column(name = "id_persona")
    private Integer idPersona;

    @Column(name = "correo")
    private String correo;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    @Column(name = "status")
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