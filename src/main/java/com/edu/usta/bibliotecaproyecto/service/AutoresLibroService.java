package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.AutoresLibro;
import com.edu.usta.bibliotecaproyecto.repository.AutoresLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoresLibroService {
    @Autowired
    private AutoresLibroRepository autoresLibroRepository;
    
    public List<AutoresLibro> listarAutoresLibros(){
        return autoresLibroRepository.findAll();
    }
    public AutoresLibro crearAutoresLibro(AutoresLibro autores_libro){
        return autoresLibroRepository.save(autores_libro);
    }
    public AutoresLibro editarAutoresLibro(AutoresLibro autores_libro){
        return autoresLibroRepository.save(autores_libro);
    }
    public Optional<AutoresLibro> findByIdAutoresLibro(Long id){
        return autoresLibroRepository.findById(id);
    }
    public void eliminarAutoresLibro(Long id){
        autoresLibroRepository.deleteById(id);
    }
    public Integer countTotalAutoresLibro(){return autoresLibroRepository.countTotalAutoresLibro();}
    
}
