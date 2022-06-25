package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.AutoresLibro;
import com.edu.usta.bibliotecaproyecto.service.AutoresLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/autoresLibro")
public class AutoresLibroRest {
    @Autowired
    private AutoresLibroService autoresLibroService;

    @GetMapping("/listar")
    private ResponseEntity<List<AutoresLibro>> listrarAutoresLibro(){
        return ResponseEntity.ok(autoresLibroService.listarAutoresLibros());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<AutoresLibro>> listrarAutoresLibroById(@PathVariable("id")Long id){
        return ResponseEntity.ok(autoresLibroService.findByIdAutoresLibro(id));
    }
    @PostMapping("/crearAutoresLibro")
    private ResponseEntity<AutoresLibro> crearAutoresLibro(@RequestBody AutoresLibro autoresLibro){
        AutoresLibro temporal = autoresLibroService.crearAutoresLibro(autoresLibro);
        try{
            return ResponseEntity.created(new URI("/api/AutoresLibro"+temporal.getCodAutoresLibro())).body(autoresLibro);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarAutoresLibro")
    private ResponseEntity<AutoresLibro>  editarSAutoresLibro(@RequestBody AutoresLibro autoresLibro){
        AutoresLibro temporal = autoresLibroService.crearAutoresLibro(autoresLibro);
        try{
            return ResponseEntity.created(new URI("/api/AutoresLibro"+temporal.getCodAutoresLibro())).body(autoresLibro);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutoresLibro(@PathVariable("id") Long id){
        autoresLibroService.eliminarAutoresLibro(id);
        return ResponseEntity.ok("AutorLibro Eliminado con Exito "+id);
    }
    @GetMapping(value = "/totalAutoresLibros")
    private ResponseEntity<String> listarTotalAutoresLibro() {
        return ResponseEntity.ok("El total de AutoresLibro es de: "
                +autoresLibroService.countTotalAutoresLibro());
    }
}
