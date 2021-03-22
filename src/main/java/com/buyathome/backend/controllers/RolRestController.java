package com.buyathome.backend.controllers;

import com.buyathome.backend.models.entity.Rol;
import com.buyathome.backend.models.services.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class RolRestController {

    @Autowired
    private IRolService rolService;

    @GetMapping("/roles")
    public List<Rol> index(){
        return rolService.findAll();
    }

    @GetMapping("/roles/{idRol}")
    public Rol show(@PathVariable int idRol){
        return rolService.findById(idRol);
    }

    @PostMapping("/roles")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol create(@RequestBody Rol rol){
        return rolService.save(rol);
    }

    @PutMapping("/roles/{idRol}")
    @ResponseStatus(HttpStatus.CREATED)
    public Rol update(@RequestBody Rol rol,@PathVariable int idRol){

        Rol rolActual = rolService.findById(idRol);

        rolActual.setRol(rol.getRol());

        return rolService.save(rolActual);
    }

    @DeleteMapping("/roles/{idRol}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int idRol){
        rolService.delete(idRol);
    }
}
