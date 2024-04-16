package com.ohgiraffers.dosirak.admin.order.model.dto;


public class DetailDTO {

    private String productName;
    private int itemQuantity;
    private int productPrice;

    public DetailDTO() {}

    public DetailDTO(String productName, int itemQuantity, int productPrice) {
        this.productName = productName;
        this.itemQuantity = itemQuantity;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "DetailDTO{" +
                "productName='" + productName + '\'' +
                ", itemQuantity=" + itemQuantity +
                ", productPrice=" + productPrice +
                '}';
    }
}
