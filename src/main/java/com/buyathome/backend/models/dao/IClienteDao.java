package com.buyathome.backend.models.dao;

import com.buyathome.backend.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

}