package com.ohgiraffers.dosirak.admin.order.model.dto;

import java.time.LocalDate;

public class OrderViewDTO {
    private String orderCode;
    private String orderStatus;
    private String refundStatus;
    private String deliveryStatus;
    private String userName;
    private String userId;
    private String orderRecipient;
    private String orderAddress;
    private int payPrice;
    private LocalDate payDate;
    private String payMethod;
    private String productName;
    private int cartItemCount;
    private int productPrice;

    public OrderViewDTO() {}

    public OrderViewDTO(String orderCode, String orderStatus, String refundStatus, String deliveryStatus, String userName, String userId, String orderRecipient, String orderAddress, int payPrice, LocalDate payDate, String payMethod, String productName, int cartItemCount, int productPrice) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.refundStatus = refundStatus;
        this.deliveryStatus = deliveryStatus;
        this.userName = userName;
        this.userId = userId;
        this.orderRecipient = orderRecipient;
        this.orderAddress = orderAddress;
        this.payPrice = payPrice;
        this.payDate = payDate;
        this.payMethod = payMethod;
        this.productName = productName;
        this.cartItemCount = cartItemCount;
        this.productPrice = productPrice;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderRecipient() {
        return orderRecipient;
    }

    public void setOrderRecipient(String orderRecipient) {
        this.orderRecipient = orderRecipient;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public int getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(int payPrice) {
        this.payPrice = payPrice;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCartItemCount() {
        return cartItemCount;
    }

    public void setCartItemCount(int cartItemCount) {
        this.cartItemCount = cartItemCount;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "OrderViewDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", payPrice=" + payPrice +
                ", payDate=" + payDate +
                ", payMethod='" + payMethod + '\'' +
                ", productName='" + productName + '\'' +
                ", cartItemCount=" + cartItemCount +
                ", productPrice=" + productPrice +
                '}';
    }
}
