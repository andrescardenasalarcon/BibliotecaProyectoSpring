package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.Editorial;
import com.edu.usta.bibliotecaproyecto.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> listarEditorial(){
        return editorialRepository.findAll();
    }
    public Editorial crearEditorial( Editorial editorial){
        return editorialRepository.save(editorial);
    }
    public Editorial editarEditorial( Editorial editorial){
        return editorialRepository.save(editorial);
    }
    public Optional<Editorial> findByIdEditorial(Long id){
        return editorialRepository.findById(id);
    }
    public void eliminarEditorial(Long id){
        editorialRepository.deleteById(id);
    }
    public Integer countTotalEditoriales(){return editorialRepository.countTotalEditorial();}
}
