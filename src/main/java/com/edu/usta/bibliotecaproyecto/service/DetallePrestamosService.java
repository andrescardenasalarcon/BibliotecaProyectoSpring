package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.DetallePrestamos;
import com.edu.usta.bibliotecaproyecto.repository.DetallePrestamosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePrestamosService {
    @Autowired
    private DetallePrestamosRepository detallePrestamosRepository;

    public List<DetallePrestamos> listarDetallePrestamos(){
        return detallePrestamosRepository.findAll();
    }
    public DetallePrestamos crearDetallePrestamos( DetallePrestamos detallePrestamos){
        return detallePrestamosRepository.save(detallePrestamos);
    }
    public DetallePrestamos editarDetallePrestamos( DetallePrestamos detallePrestamos){
        return detallePrestamosRepository.save(detallePrestamos);
    }
    public Optional<DetallePrestamos> findByIdDetallePrestamos(Long id){
        return detallePrestamosRepository.findById(id);
    }
    public void eliminarDetallePrestamos(Long id){
        detallePrestamosRepository.deleteById(id);
    }
    public Integer countTotalDetallePrestamos(){return detallePrestamosRepository.countTotalDetallePrestamos();}
    public String idDetallePrestamoLibro(Long id){return detallePrestamosRepository.idDetallePrestamosLibro(id);}
}
