package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.DetallePrestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetallePrestamosRepository extends JpaRepository<DetallePrestamos,Long> {
    @Query("SELECT COUNT(dp) FROM DetallePrestamos dp")
    public Integer countTotalDetallePrestamos();
    @Query ("SELECT dp.codDetallePrestamos as DetallePrestamo, l.codigo, l.titulo FROM DetallePrestamos dp INNER JOIN Libro l ON dp.idLibro.codigo = l.codigo WHERE dp.codDetallePrestamos = ?1")
    public String idDetallePrestamosLibro(Long id);
}
