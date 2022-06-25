package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query("SELECT COUNT(c) FROM Cliente c")
    public Integer countTotalCliente();

}
