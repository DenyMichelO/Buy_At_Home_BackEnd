package com.buyathome.backend.models.dao;

import com.buyathome.backend.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository <Usuario, Integer> {
}