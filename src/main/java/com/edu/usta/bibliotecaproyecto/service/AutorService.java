package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.Autor;
import com.edu.usta.bibliotecaproyecto.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarAutor(){return autorRepository.findAll();}
    public Autor crearAutor(Autor autor){return autorRepository.save(autor);}
    public Autor editarAutor(Autor autor){return autorRepository.save(autor);}
    public Optional<Autor> findByIdAutor (Long id) {return autorRepository.findById(id);}
    public void eliminarAutor(Long id){autorRepository.deleteById(id);}
    public Integer countTotalAutores(){return autorRepository.countTotalAutores();}
}
