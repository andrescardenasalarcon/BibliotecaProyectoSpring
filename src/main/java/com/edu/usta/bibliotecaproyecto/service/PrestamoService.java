package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.Prestamo;
import com.edu.usta.bibliotecaproyecto.repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> listarPrestamos(){
        return prestamoRepository.findAll();
    }
    public Prestamo crearPrestamo( Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }
    public Prestamo editarPrestamo( Prestamo prestamo){
        return prestamoRepository.save(prestamo);
    }
    public Optional<Prestamo> findByIdPrestamo(Long id){
        return prestamoRepository.findById(id);
    }
    public void eliminarPrestamo(Long id){
        prestamoRepository.deleteById(id);
    }
    public Integer countTotalPrestamos(){return prestamoRepository.countTotalPrestamos();}
        public String idPrestamoCliente(Long id){return prestamoRepository.idPrestamoCliente(id);}
}
