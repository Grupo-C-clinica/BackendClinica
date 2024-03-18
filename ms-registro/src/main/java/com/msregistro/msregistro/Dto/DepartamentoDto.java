package com.msregistro.msregistro.Dto;

public class DepartamentoDto {
    private Integer idDepartamento;
    private Integer idPais;
    private String nombre;
    private Boolean status;

    public DepartamentoDto() {
    }

    public DepartamentoDto(Integer idDepartamento, Integer idPais, String nombre, Boolean status) {
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
        return "DepartamentoDto{" +
                "idDepartamento=" + idDepartamento +
                ", idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", status=" + status +
                '}';
    }
}
