package com.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class OrderInfo {
    private int id;

    private String orderNum;

    private Timestamp orderTime;

    private int payMethod;

    private Double payMoney;

    private Timestamp payTime;

    private int orderStatus;

    private int shippingMethod;

    private int logisticsStatus;

    private String waybillNum;

    private int status;

    private int addressId;

    private int userId;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", payMethod=" + payMethod +
                ", payMoney=" + payMoney +
                ", payTime=" + payTime +
                ", orderStatus=" + orderStatus +
                ", shippingMethod=" + shippingMethod +
                ", logisticsStatus=" + logisticsStatus +
                ", waybillNum='" + waybillNum + '\'' +
                ", status=" + status +
                ", addressId=" + addressId +
                ", userId=" + userId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Timestamp getPayTime() {
        return payTime;
    }

    public void setPayTime(Timestamp payTime) {
        this.payTime = payTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(int shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public int getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(int logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getWaybillNum() {
        return waybillNum;
    }

    public void setWaybillNum(String waybillNum) {
        this.waybillNum = waybillNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public OrderInfo() {
    }

    public OrderInfo(int id, String orderNum, Timestamp orderTime, int payMethod, Double payMoney, Timestamp payTime, int orderStatus, int shippingMethod, int logisticsStatus, String waybillNum, int status, int addressId, int userId) {
        this.id = id;
        this.orderNum = orderNum;
        this.orderTime = orderTime;
        this.payMethod = payMethod;
        this.payMoney = payMoney;
        this.payTime = payTime;
        this.orderStatus = orderStatus;
        this.shippingMethod = shippingMethod;
        this.logisticsStatus = logisticsStatus;
        this.waybillNum = waybillNum;
        this.status = status;
        this.addressId = addressId;
        this.userId = userId;
    }
}
