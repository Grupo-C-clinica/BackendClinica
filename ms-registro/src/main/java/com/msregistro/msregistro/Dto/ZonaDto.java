package com.msregistro.msregistro.Dto;

public class ZonaDto {
    private Integer idZona;
    private Integer idCiudad;
    private String nombre;
    private Boolean status;

    public ZonaDto() {
    }

    public ZonaDto(Integer idZona, Integer idCiudad, String nombre, Boolean status) {
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
        return "ZonaDto{" +
                "idZona=" + idZona +
                ", idCiudad=" + idCiudad +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
