package com.edu.usta.bibliotecaproyecto.rest;

import com.edu.usta.bibliotecaproyecto.model.Cliente;
import com.edu.usta.bibliotecaproyecto.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
public class ClienteRest {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    private ResponseEntity<List<Cliente>> listrarAsignaturas(){
        return ResponseEntity.ok(clienteService.listarClientes());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Cliente>> listrarClienteById(@PathVariable("id")Long id){
        return ResponseEntity.ok(clienteService.findByIdCliente(id));
    }
    @PostMapping("/crearCliente")
    private ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente){
        Cliente temporal = clienteService.crearCliente(cliente);
        try{
            return ResponseEntity.created(new URI("/api/cliente"+temporal.getCodCliente())).body(cliente);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarCliente")
    private ResponseEntity<Cliente>  editarSCliente(@RequestBody Cliente cliente){
        Cliente temporal = clienteService.editarCliente(cliente);
        try{
            return ResponseEntity.created(new URI("/api/cliente"+temporal.getCodCliente())).body(cliente);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminarCliente(id);
        return ResponseEntity.ok("Cliente Eliminado Con Exito "+id);
    }
    @GetMapping(value = "/totalCliente")
    private ResponseEntity<String> listarTotalCliente() {
        return ResponseEntity.ok("Total de Clientes de: "+clienteService.countTotalClientes());
    }
}
