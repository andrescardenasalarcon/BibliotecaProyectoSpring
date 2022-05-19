package com.edu.usta.bibliotecaproyecto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private Long codLibro;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_publicacion")
    private String fechaPulbicacion;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "isbn")
    private String isbn;

    @JoinColumn(name = "id_editorial",referencedColumnName = "id_editorial")
    @ManyToOne(fetch = FetchType.EAGER)
    private Editorial idEditorial;

    public Libro() {
    }

    public Libro(Long codLibro, String titulo, String fechaPulbicacion, String codigo, String isbn, Editorial idEditorial) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.fechaPulbicacion = fechaPulbicacion;
        this.codigo = codigo;
        this.isbn = isbn;
        this.idEditorial = idEditorial;
    }

    public Long getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(Long codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFechaPulbicacion() {
        return fechaPulbicacion;
    }

    public void setFechaPulbicacion(String fechaPulbicacion) {
        this.fechaPulbicacion = fechaPulbicacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }
}
