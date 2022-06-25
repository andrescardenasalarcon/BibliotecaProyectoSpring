package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.Libro;
import com.edu.usta.bibliotecaproyecto.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("api/libro")
public class LibroRest {
    @Autowired
    private LibroService libroService;

    @GetMapping("/listar")
    private ResponseEntity<List<Libro>> listrarLibro(){
        return ResponseEntity.ok(libroService.listarLibros());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Libro>> listrarLibroById(@PathVariable("id")Long id){
        return ResponseEntity.ok(libroService.findByIdLibro(id));
    }
    @PostMapping("/crearLibro")
    private ResponseEntity<Libro> crearLibro(@RequestBody Libro libro){
        Libro temporal = libroService.crearLibro(libro);
        try{
            return ResponseEntity.created(new URI("/api/libro"+temporal.getCodLibro())).body(libro);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarLibro")
    private ResponseEntity<Libro>  editarSLibro(@RequestBody Libro libro){
        Libro temporal = libroService.editarLibro(libro);
        try{
            return ResponseEntity.created(new URI("/api/libro"+temporal.getCodLibro())).body(libro);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable("id") Long id){
        libroService.eliminarLibro(id);
        return ResponseEntity.ok("Libro Eliminado con Exito "+id);
    }
    @GetMapping(value = "/totalLibros")
    private ResponseEntity<String> listarTotalLibro() {
        return ResponseEntity.ok("El total de Libros es de: "+libroService.countTotalLibros());

    }
    @GetMapping(value = "/listarId/{id}")
    private ResponseEntity<String> libroIdEditorial(@PathVariable("id") Long id){
        return ResponseEntity.ok(libroService.idLibroEditorial(id));
    }

}
