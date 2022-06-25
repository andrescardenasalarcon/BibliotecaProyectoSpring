package com.edu.usta.bibliotecaproyecto.model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "autores_libro")
public class AutoresLibro implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autores_libro")
    private Long codAutoresLibro;

    @JoinColumn(name = "id_autor",referencedColumnName = "id_autor")
    @ManyToOne(fetch = FetchType.EAGER)
    private Autor idAutor;

    @JoinColumn(name = "id_libro",referencedColumnName = "id_libro")
    @ManyToOne(fetch = FetchType.EAGER)
    private Libro idLibro;

    public AutoresLibro() {
    }

    public AutoresLibro(Long codAutoresLibro, Autor idAutor, Libro idLibro) {
        this.codAutoresLibro = codAutoresLibro;
        this.idAutor = idAutor;
        this.idLibro = idLibro;
    }

    public Long getCodAutoresLibro() {
        return codAutoresLibro;
    }

    public void setCodAutoresLibro(Long codAutoresLibro) {
        this.codAutoresLibro = codAutoresLibro;
    }

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public Libro getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Libro idLibro) {
        this.idLibro = idLibro;
    }
}
