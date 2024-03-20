package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ANTECEDENTES_PATOLOGICOS")
public class AntecedentesPatologicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANTECEDENTES_PATOLOGICOS_ID")
    private Integer antecedentesPatologicosId;

    @Column(name = "ID_PACIENTE")
    private Integer idPaciente;

    @Column(name = "ANTECEDENTE")
    private String antecedente;

    @Column(name = "STATUS")
    private Boolean status;

    public AntecedentesPatologicos() {
    }

    public AntecedentesPatologicos(Integer antecedentesPatologicosId, Integer idPaciente, String antecedente, Boolean status) {
        this.antecedentesPatologicosId = antecedentesPatologicosId;
        this.idPaciente = idPaciente;
        this.antecedente = antecedente;
        this.status = status;
    }

    public Integer getAntecedentesPatologicosId() {
        return antecedentesPatologicosId;
    }

    public void setAntecedentesPatologicosId(Integer antecedentesPatologicosId) {
        this.antecedentesPatologicosId = antecedentesPatologicosId;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AntecedentesPatologicos{" +
                "antecedentesPatologicosId=" + antecedentesPatologicosId +
                ", idPaciente=" + idPaciente +
                ", antecedente='" + antecedente + '\'' +
                ", status=" + status +
                '}';
    }
}
