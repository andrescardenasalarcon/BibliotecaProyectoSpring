package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EditorialRepository extends JpaRepository<Editorial,Long> {
    @Query("SELECT COUNT(e) FROM Editorial e")
    public Integer countTotalEditorial();
}
