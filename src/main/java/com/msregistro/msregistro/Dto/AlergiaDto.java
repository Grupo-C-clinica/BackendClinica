package com.msregistro.msregistro.Dto;

public class AlergiaDto {
    private Integer idAlergia;
    private Integer idPaciente;
    private String tipoAlergia;
    private String causa;
    private Boolean status;

    public AlergiaDto() {
    }

    public AlergiaDto(Integer idAlergia, Integer idPaciente, String tipoAlergia, String causa, Boolean status) {
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
        return "AlergiaDto{" +
                "idAlergia=" + idAlergia +
                ", idPaciente=" + idPaciente +
                ", tipoAlergia='" + tipoAlergia + '\'' +
                ", causa='" + causa + '\'' +
                ", status=" + status +
                '}';
    }
}
