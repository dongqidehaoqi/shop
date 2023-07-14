package com.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Cart {
    private Integer id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    private Integer num;

    private Integer userId;

    private Integer productId;

    private String model;

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", time=" + time +
                ", num=" + num +
                ", userId=" + userId +
                ", productId=" + productId +
                ", model='" + model + '\'' +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public Cart() {
    }

    public Cart(Integer id, Date time, Integer num, Integer userId, Integer productId, String model) {
        this.id = id;
        this.time = time;
        this.num = num;
        this.userId = userId;
        this.productId = productId;
        this.model = model;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
