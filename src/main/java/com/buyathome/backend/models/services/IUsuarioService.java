package com.buyathome.backend.models.services;

import com.buyathome.backend.models.entity.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();

    public Usuario findById(int idUsuario);

    public Usuario save (Usuario usuario);

    public void delete(int idUsuario);

    public Usuario findByUsername(String username);
}