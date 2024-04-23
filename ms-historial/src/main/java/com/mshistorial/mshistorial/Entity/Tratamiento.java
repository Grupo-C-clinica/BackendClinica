package com.mshistorial.mshistorial.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TRATAMIENTO")
public class Tratamiento {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRATAMIENTO_ID")
    private Integer idTratamiento;

    @Column(name = "CONTENIDO")
    private String contenido;

    @Column(name = "STATUS")
    private Boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HISTORIAL_CLINICO_HISTORIAL_CLINICO_ID", nullable = false)
    private Historial historial;

    public Tratamiento() {
    }

    public Tratamiento(Integer idTratamiento, String contenido, Boolean status, Historial historial) {
        this.idTratamiento = idTratamiento;
        this.contenido = contenido;
        this.status = status;
        this.historial = historial;
    }

    public Integer getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Integer idTratamiento) {
        this.idTratamiento = idTratamiento;
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

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
    }

    @Override
    public String toString() {
        return "Tratamiento{" +
                "idTratamiento=" + idTratamiento +
                ", contenido='" + contenido + '\'' +
                ", status=" + status +
                ", historial=" + historial +
                '}';
    }
}
