package com.buyathome.backend.controllers;

import com.buyathome.backend.models.entity.Usuario;
import com.buyathome.backend.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> show(@PathVariable Integer idUsuario) {

        Usuario usuario;
        Map<String, Object> response = new HashMap<>();

        try {
            usuario = usuarioService.findById(idUsuario);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if(usuario == null){
            response.put("mensaje", "El usuario con ID: ".concat(idUsuario.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        Usuario usuarioNew;
        Map<String, Object> response = new HashMap<>();

        try {
            usuarioNew = usuarioService.save(usuario);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El usuario ha sido creado con exito");
        response.put("usuario", usuarioNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/usuarios/{idUsuario}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Integer idUsuario) {

        Usuario usuarioActual = usuarioService.findById(idUsuario);

        Usuario usuarioUpdated;

        Map<String, Object> response = new HashMap<>();

        if (usuarioActual == null) {
            response.put("mensaje", "Error: no se pudo editar, el usuario con ID: ".concat(idUsuario.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        try {

        usuarioActual.setIdRol(usuario.getIdRol());
        usuarioActual.setUsuario(usuario.getUsuario());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setNombres(usuario.getNombres());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setCi(usuario.getCi());
        usuarioActual.setTelefono(usuario.getTelefono());

        usuarioUpdated = usuarioService.save(usuarioActual);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar el usuario en la base de datos");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido actualizado con éxito");
        response.put("usuario", usuarioUpdated);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/usuarios/{idUsuario}")
    public ResponseEntity<?> delete(@PathVariable Integer idUsuario) {
        Map<String, Object> response = new HashMap<>();

        try {

            usuarioService.delete(idUsuario);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar el usuario de la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "El usuario ha sido eliminado con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}

