package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.DetallePrestamos;
import com.edu.usta.bibliotecaproyecto.service.DetallePrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/detallePrestamos")
public class DetallePrestamosRest {
    @Autowired
    private DetallePrestamosService detallePrestamosService;

    @GetMapping("/listar")
    private ResponseEntity<List<DetallePrestamos>> listrarDetallePrestamos(){
        return ResponseEntity.ok(detallePrestamosService.listarDetallePrestamos());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<DetallePrestamos>> listrarDetallePrestamosById(@PathVariable("id")Long id){
        return ResponseEntity.ok(detallePrestamosService.findByIdDetallePrestamos(id));
    }
    @PostMapping("/crearDetallePrestamos")
    private ResponseEntity<DetallePrestamos> crearDetallePrestamos(@RequestBody DetallePrestamos detallePrestamos){
        DetallePrestamos temporal = detallePrestamosService.crearDetallePrestamos(detallePrestamos);
        try{
            return ResponseEntity.created(new URI("/api/detallePrestamos"+temporal.getCodDetallePrestamos())).body(detallePrestamos);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarDetallePrestamos")
    private ResponseEntity<DetallePrestamos>  editarSDetallePrestamos(@RequestBody DetallePrestamos detallePrestamos){
        DetallePrestamos temporal = detallePrestamosService.crearDetallePrestamos(detallePrestamos);
        try{
            return ResponseEntity.created(new URI("/api/detallePrestamos"+temporal.getCodDetallePrestamos())).body(detallePrestamos);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarDetallePrestamos(@PathVariable("id") Long id){
        detallePrestamosService.eliminarDetallePrestamos(id);
        return ResponseEntity.ok("DetallePrestamo Eliminado con Exito "+id);
    }
    @GetMapping(value = "/totalDetallePrestamos")
    private ResponseEntity<String> listarTotalDetallePrestamos() {
        return ResponseEntity.ok("El total de DetallePrestamos es de: "
                +detallePrestamosService.countTotalDetallePrestamos());
    }
    @GetMapping(value = "/listarId/{id}")
    private ResponseEntity<String> detallePrestamoIdLibro(@PathVariable("id")Long id){
        return ResponseEntity.ok(detallePrestamosService.idDetallePrestamoLibro(id));
    }
}
