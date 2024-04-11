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
}
