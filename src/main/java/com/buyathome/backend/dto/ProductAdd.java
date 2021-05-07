package com.buyathome.backend.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductAdd {
    private Integer brandId;
    //@NotEmpty(message = "el campo no debe estar vacio")
    private String productName;
    private Integer tagId;
    //@NotEmpty(message = "el campo no debe estar vacio")
    private String detail;
    //@NotEmpty(message = "el campo no debe estar vacio")
    private String model;
    @NotNull(message = "el campo no debe estar vacio")
    @Min(value = 1)
    private BigDecimal price;
    @NotNull(message = "el campo no debe estar vacio")
    @Min(value = 1)
    private Integer stock;
    //@NotEmpty(message = "el campo no debe estar vacio")
    private String description;
    @NotNull(message = "debe seleccionar una opcion")
    private Boolean storeAvailable;
    @NotNull(message = "debe seleccionar una opcion")
    private Boolean deliveryAvailable;
    //@NotEmpty(message = "el campo no debe estar vacio")
    private String image;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductAdd{" +
                "brandId=" + brandId +
                ", productName='" + productName + '\'' +
                ", tagId=" + tagId +
                ", detail='" + detail + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", storeAvailable=" + storeAvailable +
                ", deliveryAvailable=" + deliveryAvailable +
                ", image='" + image + '\'' +
                '}';
    }
}
