package com.cesde.crocheteriasmaho.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String participanteNombre;
    private String participanteEmail;
    private BigDecimal precioPagado;
    private LocalDateTime fechaInscripcion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "taller_id")
    private Taller taller;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipanteNombre() {
        return participanteNombre;
    }

    public void setParticipanteNombre(String participanteNombre) {
        this.participanteNombre = participanteNombre;
    }

    public String getParticipanteEmail() {
        return participanteEmail;
    }

    public void setParticipanteEmail(String participanteEmail) {
        this.participanteEmail = participanteEmail;
    }

    public BigDecimal getPrecioPagado() {
        return precioPagado;
    }

    public void setPrecioPagado(BigDecimal precioPagado) {
        this.precioPagado = precioPagado;
    }

    public LocalDateTime getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDateTime fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Taller getTaller() {
        return taller;
    }

    public void setTaller(Taller taller) {
        this.taller = taller;
    }
}