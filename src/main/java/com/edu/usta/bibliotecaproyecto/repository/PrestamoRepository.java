package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PrestamoRepository extends JpaRepository<Prestamo,Long> {
    @Query("SELECT count(p) from Prestamo p")
    public Integer countTotalPrestamos();

    @Query("SELECT pe.codPrestamos,pe.descripcion, CONCAT(c.nombre, ' ', c.apellido) as Cliente FROM Prestamo pe INNER JOIN Cliente c on pe.idCliente.codCliente = c.codCliente WHERE pe.codPrestamos = ?1")
    public String idPrestamoCliente(Long id);
}
