package com.msregistro.msregistro.Dto;

public class PaisDto {
    private Integer idPais;
    private String nombre;
    private Boolean status;


    public PaisDto() {
    }

    public PaisDto(Integer idPais, String nombre, Boolean status) {
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
        return "PaisDto{" +
                "idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
