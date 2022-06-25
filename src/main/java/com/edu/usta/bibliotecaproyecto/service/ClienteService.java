package com.edu.usta.bibliotecaproyecto.service;

import com.edu.usta.bibliotecaproyecto.model.Cliente;
import com.edu.usta.bibliotecaproyecto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }
    public Cliente crearCliente( Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Cliente editarCliente( Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public Optional<Cliente> findByIdCliente(Long id){
        return clienteRepository.findById(id);
    }
    public void eliminarCliente(Long id){
        clienteRepository.deleteById(id);
    }
    public Integer countTotalClientes(){
        return clienteRepository.countTotalCliente();
    }
}
