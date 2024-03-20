package com.msregistro.msregistro.Dto;

public class AntecedentesPatologicosDto {
    private Integer antecedentesPatologicosId;
    private Integer idPaciente;
    private String antecedente;
    private Boolean status;

    public AntecedentesPatologicosDto() {
    }

    public AntecedentesPatologicosDto(Integer antecedentesPatologicosId, Integer idPaciente, String antecedente, Boolean status) {
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
        return "AntecedentesPatologicosDto{" +
                "antecedentesPatologicosId=" + antecedentesPatologicosId +
                ", idPaciente=" + idPaciente +
                ", antecedente='" + antecedente + '\'' +
                ", status=" + status +
                '}';
    }
}
