package com.buyathome.backend.models.services;

import com.buyathome.backend.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
}