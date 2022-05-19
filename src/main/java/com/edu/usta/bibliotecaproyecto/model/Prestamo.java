package com.edu.usta.bibliotecaproyecto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prestamos")
    private Long codPrestamos;

    @Column(name = "fecha_inicio")
    private String fechaInicio;

    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "id_cliente",referencedColumnName = "id_cliente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente idCliente;

    public Prestamo() {
    }

    public Prestamo(Long codPrestamos, String fechaInicio, String descripcion, Cliente idCliente) {
        this.codPrestamos = codPrestamos;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
        this.idCliente = idCliente;
    }

    public Long getCodPrestamos() {
        return codPrestamos;
    }

    public void setCodPrestamos(Long codPrestamos) {
        this.codPrestamos = codPrestamos;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }
}
