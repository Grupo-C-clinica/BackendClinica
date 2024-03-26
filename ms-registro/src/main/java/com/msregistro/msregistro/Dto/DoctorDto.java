package com.msregistro.msregistro.Dto;

public class DoctorDto {
    private Integer idDoctor;
    private Integer idPersona;
    private String username;
    private String correo;
    private String password;
    private Boolean status;

    public DoctorDto() {
    }

    public DoctorDto(Integer idDoctor, Integer idPersona, String username, String correo, String password, Boolean status) {
        this.idDoctor = idDoctor;
        this.idPersona = idPersona;
        this.username = username;
        this.correo = correo;
        this.password = password;
        this.status = status;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "idDoctor=" + idDoctor +
                ", idPersona=" + idPersona +
                ", username='" + username + '\'' +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}