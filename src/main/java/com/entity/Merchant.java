package com.entity;

import java.util.Date;

public class Merchant {
    private Integer id;

    private String headProtrait;

    private String shopName;

    private String ownerName;

    private Date createTime;

    private Byte goodsGrade;

    private Byte serviceGrade;

    private Byte logisticsGrade;

    private Integer fansNum;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadProtrait() {
        return headProtrait;
    }

    public void setHeadProtrait(String headProtrait) {
        this.headProtrait = headProtrait == null ? null : headProtrait.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName == null ? null : ownerName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getGoodsGrade() {
        return goodsGrade;
    }

    public void setGoodsGrade(Byte goodsGrade) {
        this.goodsGrade = goodsGrade;
    }

    public Byte getServiceGrade() {
        return serviceGrade;
    }

    public void setServiceGrade(Byte serviceGrade) {
        this.serviceGrade = serviceGrade;
    }

    public Byte getLogisticsGrade() {
        return logisticsGrade;
    }

    public void setLogisticsGrade(Byte logisticsGrade) {
        this.logisticsGrade = logisticsGrade;
    }

    public Integer getFansNum() {
        return fansNum;
    }

    public void setFansNum(Integer fansNum) {
        this.fansNum = fansNum;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}