package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    @Query("SELECT COUNT(l) FROM Libro l")
    public Integer countTotalLibros();

    @Query("SELECT l.idEditorial.codEditorial, l.titulo,e.codEditorial,e.nombre FROM Libro l INNER JOIN Editorial e ON e.codEditorial = l.idEditorial.codEditorial WHERE l.idEditorial.codEditorial = ?1")
        public String idEditorial(Long id);
}
