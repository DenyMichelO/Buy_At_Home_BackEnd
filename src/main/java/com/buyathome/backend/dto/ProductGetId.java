package com.buyathome.backend.dto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductGetId {

    private Integer productId;
    private String image;
    private Integer stock;
    private BigDecimal price;
    private String productName;
    private String model;
    private String Description;
    private String Detail;
    public ProductGetId(){

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    @Override
    public String toString() {
        return "ProductGetId{" +
                "productId=" + productId +
                ", image='" + image + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", model='" + model + '\'' +
                ", Description='" + Description + '\'' +
                ", Detail='" + Detail + '\'' +
                '}';
    }
}
