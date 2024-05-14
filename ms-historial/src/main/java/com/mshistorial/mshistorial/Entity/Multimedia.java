package com.mshistorial.mshistorial.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "MULTIMEDIA_CLINICA")
public class Multimedia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MULTIMEDIA_CLINICA_ID")
    private Integer idMultimedia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "HISTORIAL_CLINICO_ID", nullable = false)
    private Historial historial;

    @Column(name = "MULTIMEDIA")
    private String multimedia;

    @Column(name = "STATUS")
    private Boolean status;

    public Multimedia() {
    }

    public Multimedia(Integer idMultimedia, Historial historial, String multimedia, Boolean status) {
        this.idMultimedia = idMultimedia;
        this.historial = historial;
        this.multimedia = multimedia;
        this.status = status;
    }

    public Integer getIdMultimedia() {
        return idMultimedia;
    }

    public void setIdMultimedia(Integer idMultimedia) {
        this.idMultimedia = idMultimedia;
    }

    public Historial getHistorial() {
        return historial;
    }

    public void setHistorial(Historial historial) {
        this.historial = historial;
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
        return "Multimedia{" +
                "idMultimedia=" + idMultimedia +
                ", historial=" + historial +
                ", multimedia='" + multimedia + '\'' +
                ", status=" + status +
                '}';
    }
}
