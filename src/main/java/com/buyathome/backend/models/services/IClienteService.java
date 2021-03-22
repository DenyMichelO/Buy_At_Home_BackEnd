package com.buyathome.backend.models.services;

import com.buyathome.backend.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findById(int idCLiente);

    public Cliente save (Cliente cliente);

    public void delete(int idCliente);

}