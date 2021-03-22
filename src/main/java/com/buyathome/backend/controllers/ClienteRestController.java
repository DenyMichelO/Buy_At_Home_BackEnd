package com.buyathome.backend.controllers;

import com.buyathome.backend.models.entity.Cliente;
import com.buyathome.backend.models.services.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("/clientes/{idCliente}")
    public Cliente show(@PathVariable int idCliente){
        return clienteService.findById(idCliente);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{idCliente}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente update(@RequestBody Cliente cliente, @PathVariable int idCliente){
        Cliente clienteActual = clienteService.findById(idCliente);

        clienteActual.setCorreo(cliente.getCorreo());
        clienteActual.setPassword(cliente.getPassword());
        clienteActual.setNombres(cliente.getNombres());
        clienteActual.setApellidos(cliente.getApellidos());
        clienteActual.setFechaNacimiento(cliente.getFechaNacimiento());
        clienteActual.setTelefono(cliente.getTelefono());
        clienteActual.setDireccion(cliente.getDireccion());

        return clienteService.save(clienteActual);
    }

    @DeleteMapping("/clientes/{idCliente}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int idCliente){
        clienteService.delete(idCliente);
    }

}
