package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TIPO_CITA")
public class TipoCita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_CITA")
    private Integer idTipoCita;

    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public TipoCita() {
    }

    public TipoCita(Integer idTipoCita, String nombre, Boolean status) {
        this.idTipoCita = idTipoCita;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getIdTipoCita() {
        return idTipoCita;
    }

    public void setIdTipoCita(Integer idTipoCita) {
        this.idTipoCita = idTipoCita;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TipoCita{" +
                "idTipoCita=" + idTipoCita +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
