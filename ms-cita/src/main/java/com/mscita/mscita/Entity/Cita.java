package com.mscita.mscita.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CITA")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CITA")
    private Integer idCita;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_CITA", nullable = false)
    private TipoCita tipoCita;

    @ManyToOne
    @JoinColumn(name = "ID_HORARIO", nullable = false)
    private Horario horario;

    @Column(name = "ID_PACIENTE", nullable = false)
    private Integer idPaciente;

    @Column(name = "ID_ASISTENTE", nullable = false)
    private Integer idAsistente;
    @Column(name = "HORA", nullable = false)
    private String hora;

    @Column(name = "FECHA", nullable = false)
    private String fecha;
    @Column(name = "RAZON", nullable = false)
    private String razon;

    @Column(name = "STATUS", nullable = false)
    private Boolean status;

    public Cita() {
    }

    public Cita(Integer idCita, TipoCita tipoCita, Horario horario, Integer idPaciente, Integer idAsistente, String hora, String fecha, String razon, Boolean status) {
        this.idCita = idCita;
        this.tipoCita = tipoCita;
        this.horario = horario;
        this.idPaciente = idPaciente;
        this.idAsistente = idAsistente;
        this.hora = hora;
        this.fecha = fecha;
        this.razon = razon;
        this.status = status;
    }

    public Integer getIdCita() {
        return idCita;
    }

    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }

    public TipoCita getTipoCita() {
        return tipoCita;
    }

    public void setTipoCita(TipoCita tipoCita) {
        this.tipoCita = tipoCita;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdAsistente() {
        return idAsistente;
    }

    public void setIdAsistente(Integer idAsistente) {
        this.idAsistente = idAsistente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", tipoCita=" + tipoCita +
                ", horario=" + horario +
                ", idPaciente=" + idPaciente +
                ", idAsistente=" + idAsistente +
                ", hora='" + hora + '\'' +
                ", fecha='" + fecha + '\'' +
                ", razon='" + razon + '\'' +
                ", status=" + status +
                '}';
    }
}
