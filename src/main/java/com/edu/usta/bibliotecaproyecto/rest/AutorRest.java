package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.Autor;
import com.edu.usta.bibliotecaproyecto.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/autor")
public class AutorRest {
    @Autowired
    private AutorService autorService;

    @GetMapping("/listar")
    private ResponseEntity<List<Autor>> listrarAutor(){
        return ResponseEntity.ok(autorService.listarAutor());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Autor>> listrarAutorById(@PathVariable("id")Long id){
        return ResponseEntity.ok(autorService.findByIdAutor(id));
    }
    @PostMapping("/crearAutor")
    private ResponseEntity<Autor> crearAutor(@RequestBody Autor autor){
        Autor temporal = autorService.crearAutor(autor);
        try{
            return ResponseEntity.created(new URI("/api/autor"+temporal.getCodAutor())).body(autor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarAutor")
    private ResponseEntity<Autor>  editarAutor(@RequestBody Autor autor){
        Autor temporal = autorService.editarAutor(autor);
        try{
            return ResponseEntity.created(new URI("/api/autor"+temporal.getCodAutor())).body(autor);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAutor(@PathVariable("id") Long id){
        autorService.eliminarAutor(id);
        return ResponseEntity.ok("Autor Eliminado con Exito "+id);
    }
    @GetMapping(value = "/totalAutor")
    private ResponseEntity<String> listarTotalAutor() {
        return ResponseEntity.ok("El total de Autores es de: "+autorService.countTotalAutores());
    }
}
