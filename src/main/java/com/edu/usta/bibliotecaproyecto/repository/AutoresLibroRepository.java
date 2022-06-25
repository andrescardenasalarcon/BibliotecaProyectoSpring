package com.edu.usta.bibliotecaproyecto.repository;

import com.edu.usta.bibliotecaproyecto.model.AutoresLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutoresLibroRepository extends JpaRepository<AutoresLibro,Long> {
    @Query("SELECT count(al) FROM AutoresLibro al")
    public Integer countTotalAutoresLibro();




}
