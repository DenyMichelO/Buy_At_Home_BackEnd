package com.buyathome.backend.dto;

import com.buyathome.backend.domain.Clientes;

import java.util.Date;

public class ClientesDto {

    private Integer id_cliente;
    private String correo;
    private String password;
    private Integer estado;
    private String nombres;
    private String apellidos;
    private Date fecha_nacimiento;
    private String telefono;
    private String direccion;

    public ClientesDto() {
    }
    public ClientesDto(Clientes clinetes){

    }

}
