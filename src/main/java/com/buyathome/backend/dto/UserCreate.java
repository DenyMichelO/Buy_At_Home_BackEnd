package com.buyathome.backend.dto;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
public class UserCreate {
    @NotEmpty(message = "el campo no debe estar vacio")
    private String firstname;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String lastname;
    @NotEmpty (message = "el campo no debe estar vacio")
    private String phone;
    @Email (message = "el campo debe ser llenado con un correo verdadero")
    private String email;
    @NotEmpty (message = "el campo no debe estar vacio")
    private String password;
    @NotNull (message = "el campo no debe estar vacio")
    private Integer neighbourId;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String street;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String number;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String reference;

    public UserCreate(){
    }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Integer getNeighbourId() { return neighbourId; }
    public void setNeighbourId(Integer neighbourId) { this.neighbourId = neighbourId; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    @Override
    public String toString() {
        return "UserCreate{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", neighbourId=" + neighbourId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
