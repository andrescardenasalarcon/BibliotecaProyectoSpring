package com.edu.usta.bibliotecaproyecto.repository;


import com.edu.usta.bibliotecaproyecto.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    @Query("SELECT count(a) FROM Autor a")
    public Integer countTotalAutores();
}
