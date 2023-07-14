package com.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Description
 * @Author qiqi
 * @Date 2023/6/24
 * @Version 1.0
 * @Since 1.0
 */
@JsonIgnoreProperties
public class Data {

    private Integer num;

    private Integer productId;

    private String model;

    private Double preferentialPrice;

    private Integer id;

    private Integer inventoryNum;

    private boolean isChecked;

    private Double marketPrice;

    private Integer pictureId;

    private String pictureName;

    private String shopName;

    private String detailInfo;

    private Integer merchantId;

    @Override
    public String toString() {
        return "Data{" +
                "num=" + num +
                ", productId=" + productId +
                ", model='" + model + '\'' +
                ", preferentialPrice=" + preferentialPrice +
                ", id=" + id +
                ", inventoryNum=" + inventoryNum +
                ", isChecked=" + isChecked +
                ", marketPrice=" + marketPrice +
                ", pictureId=" + pictureId +
                ", pictureName='" + pictureName + '\'' +
                ", shopName='" + shopName + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", merchantId=" + merchantId +
                '}';
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Data(Integer num, Integer productId, String model, Double preferentialPrice, Integer id, Integer inventoryNum, boolean isChecked, Double marketPrice, Integer pictureId, String pictureName, String shopName, String detailInfo, Integer merchantId) {
        this.num = num;
        this.productId = productId;
        this.model = model;
        this.preferentialPrice = preferentialPrice;
        this.id = id;
        this.inventoryNum = inventoryNum;
        this.isChecked = isChecked;
        this.marketPrice = marketPrice;
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.shopName = shopName;
        this.detailInfo = detailInfo;
        this.merchantId = merchantId;
    }

    public Data(Integer num, Integer productId, String model, Double preferentialPrice, Integer id, Integer inventoryNum, boolean isChecked, Double marketPrice, Integer pictureId, String pictureName, String detailInfo, String shopName) {
        this.num = num;
        this.productId = productId;
        this.model = model;
        this.preferentialPrice = preferentialPrice;
        this.id = id;
        this.inventoryNum = inventoryNum;
        this.isChecked = isChecked;
        this.marketPrice = marketPrice;
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.detailInfo = detailInfo;
        this.shopName = shopName;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }


    public Data(Integer num, Integer productId, String model, Double preferentialPrice, Integer id, Integer inventoryNum, boolean isChecked, Double marketPrice, Integer pictureId, String pictureName, String shopName) {
        this.num = num;
        this.productId = productId;
        this.model = model;
        this.preferentialPrice = preferentialPrice;
        this.id = id;
        this.inventoryNum = inventoryNum;
        this.isChecked = isChecked;
        this.marketPrice = marketPrice;
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.shopName = shopName;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInventoryNum() {
        return inventoryNum;
    }

    public void setInventoryNum(Integer inventoryNum) {
        this.inventoryNum = inventoryNum;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean checked) {
        isChecked = checked;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPreferentialPrice() {
        return preferentialPrice;
    }

    public void setPreferentialPrice(Double preferentialPrice) {
        this.preferentialPrice = preferentialPrice;
    }

    public Data() {
    }



}
