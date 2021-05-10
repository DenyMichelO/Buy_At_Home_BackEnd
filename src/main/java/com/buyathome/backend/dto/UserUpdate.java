package com.buyathome.backend.dto;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Service
public class UserUpdate {

    private Integer addressId;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String firstname;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String lastname;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String phone;
    @Email (message = "el campo debe llenarse con un correo real")
    private String email;
    @NotNull (message = "el campo no debe estar vacio")
    private Integer neighbourId;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String street;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String number;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String reference;

    public UserUpdate(){
    }

    public Integer getAddressId() {
        return addressId;
    }
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

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
        return "UserUpdate{" +
                "addressId=" + addressId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", neighbourId=" + neighbourId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
