package com.msregistro.msregistro.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "departamento")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departamento")
    private Integer idDepartamento;

    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "status")
    private Boolean status;

    public Departamento() {
    }

    public Departamento(Integer idDepartamento, Integer idPais, String nombre, Boolean status) {
        this.idDepartamento = idDepartamento;
        this.idPais = idPais;
        this.nombre = nombre;
        this.status = status;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
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
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
