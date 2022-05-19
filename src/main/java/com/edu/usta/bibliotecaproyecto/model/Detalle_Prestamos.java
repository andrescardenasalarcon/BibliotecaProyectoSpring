package com.edu.usta.bibliotecaproyecto.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "detalle_prestamos")
public class Detalle_Prestamos implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle_prestamos")
    private Long codDetallePrestamos;

    @Column(name = "fecha_devolucion")
    private Date fechaDevolucion;

    @Column(name = "dias_mora")
    private int diasMora;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_entrega")
    private Date fechaEntrega;

    @JoinColumn(name = "id_prestamo",referencedColumnName = "id_prestamo")
    @ManyToOne(fetch = FetchType.EAGER)
    private Prestamo idPrestamo;

    @JoinColumn(name = "id_libro",referencedColumnName = "id_libro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Libro idLibro;

    public Detalle_Prestamos() {
    }

    public Detalle_Prestamos(Long codDetallePrestamos, Date fechaDevolucion, int diasMora, String descripcion, Date fechaEntrega, Prestamo idPrestamo, Libro idLibro) {
        this.codDetallePrestamos = codDetallePrestamos;
        this.fechaDevolucion = fechaDevolucion;
        this.diasMora = diasMora;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.idPrestamo = idPrestamo;
        this.idLibro = idLibro;
    }

    public Long getCodDetallePrestamos() {
        return codDetallePrestamos;
    }

    public void setCodDetallePrestamos(Long codDetallePrestamos) {
        this.codDetallePrestamos = codDetallePrestamos;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getDiasMora() {
        return diasMora;
    }

    public void setDiasMora(int diasMora) {
        this.diasMora = diasMora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Prestamo getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(Prestamo idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }
}
