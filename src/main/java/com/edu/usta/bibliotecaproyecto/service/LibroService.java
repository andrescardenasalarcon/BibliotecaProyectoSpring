package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.Libro;
import com.edu.usta.bibliotecaproyecto.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listarLibros(){
        return libroRepository.findAll();
    }
    public Libro crearLibro( Libro libro){
        return libroRepository.save(libro);
    }
    public Libro editarLibro( Libro libro){
        return libroRepository.save(libro);
    }
    public Optional<Libro> findByIdLibro(Long id){
        return libroRepository.findById(id);
    }
    public void eliminarLibro(Long id){
        libroRepository.deleteById(id);
    }
    public Integer countTotalLibros(){return libroRepository.countTotalLibros();}
    public String idLibroEditorial(Long id){return libroRepository.idEditorial(id);}

}
