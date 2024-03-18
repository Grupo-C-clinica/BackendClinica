package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "zona")
public class Zona implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zona")
    private Integer idZona;

    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "status")
    private Boolean status;

    public Zona() {
    }

    public Zona(Integer idZona, Integer idCiudad, String nombre, Boolean status) {
        this.idZona = idZona;
        this.idCiudad = idCiudad;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
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
        return "Zona{" +
                "idZona=" + idZona +
                ", idCiudad=" + idCiudad +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
