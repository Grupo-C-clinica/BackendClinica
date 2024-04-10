package com.mshistorial.mshistorial.Dto;

import java.util.Date;

public class PacienteDto {
    private Integer idPaciente;
    private Integer idZona;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private Date fechaNacimiento;
    private String genero;
    private String telefono;
    private String ci;
    private String correo;
    private String tipoSangre;
    private Boolean status;

    public PacienteDto() {
    }

    public PacienteDto(Integer idPaciente, Integer idZona, String nombre, String apellidoP, String apellidoM, Date fechaNacimiento, String genero, String telefono, String ci, String correo, String tipoSangre, Boolean status) {
        this.idPaciente = idPaciente;
        this.idZona = idZona;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.telefono = telefono;
        this.ci = ci;
        this.correo = correo;
        this.tipoSangre = tipoSangre;
        this.status = status;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PacienteDto{" +
                "idPaciente=" + idPaciente +
                ", idZona=" + idZona +
                ", nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero='" + genero + '\'' +
                ", telefono='" + telefono + '\'' +
                ", ci='" + ci + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", status=" + status +
                '}';
    }
}
