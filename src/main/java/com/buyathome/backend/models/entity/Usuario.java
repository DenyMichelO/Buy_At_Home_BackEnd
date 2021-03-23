package com.buyathome.backend.models.entity;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "id_rol")
    private Integer idRol;

    @Pattern(regexp = "[a-z]+", message="El nombre de usuario solo puede contener letras minusculas")
    private String usuario;
    @Size(min = 8, message="La contraseña debe tener 8 caracteres como minimo")
    @Pattern(regexp = "^[a-zA-Z]\\w{3,14}$", message = "Debe contener letras seguidos de numeros")
    private String password;
    private Integer estado;
    @NotBlank(message="Dato obligatorio")
    private String nombres;
    @NotBlank(message="Dato obligatorio")
    private String apellidos;
    @Column(unique = true)
    @NotBlank
    @Email(message = "El correo electrónico debe ser válido")
    private String email;
    @NotBlank(message="Dato obligatorio")
    private String ci;
    @NotBlank (message = "Dato obligatorio")
    @Min(600000000)
    @Max(799999999)
    private String telefono;

    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }
    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEstado() {
        return estado;
    }
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCi() {
        return ci;
    }
    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    private static final long serialVersionUID = 1L;
}
