package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.Editorial;
import com.edu.usta.bibliotecaproyecto.service.EditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/editorial")
public class EditorialRest {
    @Autowired
    private EditorialService editorialService;

    @GetMapping("/listar")
    private ResponseEntity<List<Editorial>> listrarEditorial(){
        return ResponseEntity.ok(editorialService.listarEditorial());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Editorial>> listrarEditorialById(@PathVariable("id")Long id){
        return ResponseEntity.ok(editorialService.findByIdEditorial(id));
    }
    @PostMapping("/crearEditorial")
    private ResponseEntity<Editorial> crearEditorial(@RequestBody Editorial editorial){
        Editorial temporal = editorialService.crearEditorial(editorial);
        try{
            return ResponseEntity.created(new URI("/api/editorial("+temporal.getCodEditorial())).body(editorial);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarEditorial")
    private ResponseEntity<Editorial>  editarSEditorial(@RequestBody Editorial editorial){
        Editorial temporal = editorialService.crearEditorial(editorial);
        try{
            return ResponseEntity.created(new URI("/api/editorial("+temporal.getCodEditorial())).body(editorial);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEditorial(@PathVariable("id") Long id){
        editorialService.eliminarEditorial(id);
        return ResponseEntity.ok("Editorial Eliminada con Exito "+id);
    }
    @GetMapping(value = "/totalEditorial")
    private ResponseEntity<String> listarTotalEditorial() {
        return ResponseEntity.ok("El total de EDitoriales es de: "+editorialService.countTotalEditoriales());
    }
}
