package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ALERGIA")
public class Alergia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ALERGIA")
    private Integer idAlergia;

    @Column(name = "ID_PACIENTE")
    private Integer idPaciente;

    @Column(name = "TIPO_ALERGIA")
    private String tipoAlergia;

    @Column(name = "CAUSA")
    private String causa;

    @Column(name = "STATUS")
    private Boolean status;

    public Alergia() {
    }

    public Alergia(Integer idAlergia, Integer idPaciente, String tipoAlergia, String causa, Boolean status) {
        this.idAlergia = idAlergia;
        this.idPaciente = idPaciente;
        this.tipoAlergia = tipoAlergia;
        this.causa = causa;
        this.status = status;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getTipoAlergia() {
        return tipoAlergia;
    }

    public void setTipoAlergia(String tipoAlergia) {
        this.tipoAlergia = tipoAlergia;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Alergia{" +
                "idAlergia=" + idAlergia +
                ", idPaciente=" + idPaciente +
                ", tipoAlergia='" + tipoAlergia + '\'' +
                ", causa='" + causa + '\'' +
                ", status=" + status +
                '}';
    }
}
