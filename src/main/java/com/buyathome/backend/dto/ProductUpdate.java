package com.buyathome.backend.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


public class ProductUpdate {
    @NotNull(message = "el campo no debe estar vacio")
    @Min(value = 1, message = "el valor minimo para el precio no debe ser menor a 1")
    private BigDecimal price;
    @NotNull(message = "el campo no debe estar vacio")
    @Min(value = 1, message = "el valor minimo que debe añadirse a stock debe ser 1")
    private Integer stock;
    @NotNull(message = "debe seleccionar una opcion")
    private Boolean storeAvailable;
    @NotNull(message = "debe seleccionar una opcion")
    private Boolean deliveryAvailable;



    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getStoreAvailable() {
        return storeAvailable;
    }

    public void setStoreAvailable(Boolean storeAvailable) {
        this.storeAvailable = storeAvailable;
    }

    public Boolean getDeliveryAvailable() {
        return deliveryAvailable;
    }

    public void setDeliveryAvailable(Boolean deliveryAvailable) {
        this.deliveryAvailable = deliveryAvailable;
    }

    @Override
    public String toString() {
        return "ProductUpdate{" +
                "price=" + price +
                ", stock=" + stock +
                ", storeAvailable=" + storeAvailable +
                ", deliveryAvailable=" + deliveryAvailable +
                '}';
    }
}
