package com.mshistorial.mshistorial.Dto;

import com.mshistorial.mshistorial.Entity.Paciente;

import java.util.Date;

public class HistorialDto {
    private Integer idHistorial;
    private Integer idPaciente;
    private Date fecha;
    private String observaciones;
    private Boolean status;

    public HistorialDto() {
    }

    public HistorialDto(Integer idHistorial, Paciente idPaciente, Date fecha, String observaciones, Boolean status) {
        this.idHistorial = idHistorial;
        this.idPaciente = idPaciente;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.status = status;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "idHistorial=" + idHistorial +
                ", idPaciente=" + idPaciente +
                ", fecha=" + fecha +
                ", observaciones='" + observaciones + '\'' +
                ", status=" + status +
                '}';
    }
}
