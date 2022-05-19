package com.edu.usta.bibliotecaproyecto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "editorial")
public class Editorial implements Serializable {
    private static final long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private Long codEditorial;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @Column(name = "telefono")
    private String telefono;

    public Editorial() {
    }

    public Editorial(Long codEditorial, String nombre, String pais, String telefono) {
        this.codEditorial = codEditorial;
        this.nombre = nombre;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Long getCodEditorial() {
        return codEditorial;
    }

    public void setCodEditorial(Long codEditorial) {
        this.codEditorial = codEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
