package com.buyathome.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

public class UserGetOrderId {

    private Integer orderId;
    private String image;
    private Integer qtty;
    private  String productName;
    private BigDecimal price;
    private String neighbour;
    private String street;
    private String number;
    private Date date;
    private Integer state;
    private BigDecimal total;

    public UserGetOrderId(){
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Integer getQtty() { return qtty; }
    public void setQtty(Integer qtty) { this.qtty = qtty; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public String getNeighbour() { return neighbour; }
    public void setNeighbour(String neighbour) { this.neighbour = neighbour; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public Integer getState() { return state; }
    public void setState(Integer state) { this.state = state; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    @Override
    public String toString() {
        return "UserGetOrderId{" +
                "orderId=" + orderId +
                ", image='" + image + '\'' +
                ", qtty=" + qtty +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", neighbour='" + neighbour + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", date=" + date +
                ", state=" + state +
                ", total=" + total +
                '}';
    }
}
