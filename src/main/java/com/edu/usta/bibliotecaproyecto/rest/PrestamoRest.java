package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.Prestamo;
import com.edu.usta.bibliotecaproyecto.service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/prestamo")
public class PrestamoRest {
    @Autowired
    private PrestamoService prestamoService;

    @GetMapping("/listar")
    private ResponseEntity<List<Prestamo>> listrarPrestamo(){
        return ResponseEntity.ok(prestamoService.listarPrestamos());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Prestamo>> listrarPrestamoById(@PathVariable("id")Long id){
        return ResponseEntity.ok(prestamoService.findByIdPrestamo(id));
    }
    @PostMapping("/crearPrestamo")
    private ResponseEntity<Prestamo> crearPrestamo(@RequestBody Prestamo prestamo){
        Prestamo temporal = prestamoService.crearPrestamo(prestamo);
        ResponseEntity.ok("Creado Con exito");
        try{
            return ResponseEntity.created(new URI("/api/prestamo"+temporal.getCodPrestamos())).body(prestamo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarPrestamo")
    private ResponseEntity<Prestamo>  editarPrestamo(@RequestBody Prestamo prestamo){
        Prestamo temporal = prestamoService.editarPrestamo(prestamo);
        try{
            return ResponseEntity.created(new URI("/api/prestamo"+temporal.getCodPrestamos())).body(prestamo);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPrestamo(@PathVariable("id") Long id){
        prestamoService.eliminarPrestamo(id);
        return ResponseEntity.ok("Prestamo Eliminado con Exito "+id);
    }
    @GetMapping(value = "/totalPrestamos")
    private ResponseEntity<String> listarTotalPrestamo() {
        return ResponseEntity.ok("El total de Prestamos es de: "+prestamoService.countTotalPrestamos());
    }
    @GetMapping(value = "/listarId/{id}")
    private ResponseEntity<String> prestamoIdCliente(@PathVariable("id")Long id){
        return ResponseEntity.ok(prestamoService.idPrestamoCliente(id));
    }
}
