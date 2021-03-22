package com.buyathome.backend.controllers;

import com.buyathome.backend.models.entity.Usuario;
import com.buyathome.backend.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> index(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{idUsuario}")
    public Usuario show(@PathVariable int idUsuario){
        return usuarioService.findById(idUsuario);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuarios/{idUsuario}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario update(@RequestBody Usuario usuario, @PathVariable int idUsuario){

        Usuario usuarioActual = usuarioService.findById(idUsuario);

        usuarioActual.setIdRol(usuario.getIdRol());
        usuarioActual.setUsuario(usuario.getUsuario());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setNombres(usuario.getNombres());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setCi(usuario.getCi());
        usuarioActual.setTelefono(usuario.getTelefono());

        return usuarioService.save(usuarioActual);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int idUsuario){
        usuarioService.delete(idUsuario);
    }

}

