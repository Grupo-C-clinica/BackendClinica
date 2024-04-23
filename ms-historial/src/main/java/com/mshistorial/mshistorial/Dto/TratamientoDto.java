package com.mshistorial.mshistorial.Dto;

public class TratamientoDto {
    private Integer idTratamiento;
    private Integer idHistorial;
    private String contenido;
    private Boolean status;

    public TratamientoDto() {
    }
    public TratamientoDto(Integer idTratamiento, Integer idHistorial, String contenido, Boolean status) {
        this.idTratamiento = idTratamiento;
        this.idHistorial = idHistorial;
        this.contenido = contenido;
        this.status = status;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TratamiendoDto{" +
                "idTratamiento=" + idTratamiento +
                ", idHistorial=" + idHistorial +
                ", contenido='" + contenido + '\'' +
                ", status=" + status +
                '}';
    }
}
