package com.mshistorial.mshistorial.Dto;

public class MultimediaDto {
    private Integer idMultimedia;
    private Integer idHistorial;
    private String multimedia;
    private Boolean status;

    public MultimediaDto() {
    }

    public MultimediaDto(Integer idMultimedia, Integer idHistorial, String multimedia, Boolean status) {
        this.idMultimedia = idMultimedia;
        this.idHistorial = idHistorial;
        this.multimedia = multimedia;
        this.status = status;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Integer getIdHistorial() {
        return idHistorial;
    }

    public void setIdHistorial(Integer idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(String multimedia) {
        this.multimedia = multimedia;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MultimediaDto{" +
                "idMultimedia=" + idMultimedia +
                ", idHistorial=" + idHistorial +
                ", multimedia='" + multimedia + '\'' +
                ", status=" + status +
                '}';
    }
}
