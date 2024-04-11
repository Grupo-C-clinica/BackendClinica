package com.mshistorial.mshistorial.Entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name= "HISTORIAL_CLINICO")
public class Historial implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HISTORIAL_CLINICO_ID")
    private Integer idHistorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PACIENTE", nullable = false)
    private Paciente paciente;

    @Column(name = "FECHA")
    private Date fecha;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    @Column(name = "STATUA")
    private Boolean status;

    public Historial() {
    }

    public Historial(Integer idHistorial, Paciente paciente, Date fecha, String observaciones, Boolean status) {
        this.idHistorial = idHistorial;
        this.paciente = paciente;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
                ", paciente=" + paciente +
                ", fecha=" + fecha +
                ", observaciones='" + observaciones + '\'' +
                ", status=" + status +
                '}';
    }
}
