package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pais")
public class Pais implements Serializable {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "status")
    private Boolean status;

    public Pais() {
    }

    public Pais(Integer idPais, String nombre, Boolean status) {
        this.idPais = idPais;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
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
        return "Pais{" +
                "idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
