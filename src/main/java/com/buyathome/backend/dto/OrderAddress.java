package com.buyathome.backend.dto;

import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;

@Service
public class OrderAddress {
    @NotEmpty(message = "el campo no debe estar vacio")
    private Integer neighbourId;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String street;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String number;
    @NotEmpty(message = "el campo no debe estar vacio")
    private String reference;
    public OrderAddress(){

    }

    public Integer getNeighbourId() {
        return neighbourId;
    }

    public void setNeighbourId(Integer neighbourId) {
        this.neighbourId = neighbourId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "neighbourId=" + neighbourId +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", reference='" + reference + '\'' +
                '}';
    }
}
