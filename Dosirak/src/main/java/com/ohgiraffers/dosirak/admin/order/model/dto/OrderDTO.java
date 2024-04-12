package com.ohgiraffers.dosirak.admin.order.model.dto;

import lombok.*;

import java.util.Date;

public class OrderDTO {

    private String orderCode;
    private String orderStatus;
    private String userId;
    private String orderRecipient;
    private int payPrice;
    private Date payDate;
    private boolean payStatus;
    private String payMethod;

    public OrderDTO() {}

    public OrderDTO(String orderCode, String orderStatus, String userId, String orderRecipient, int payPrice, Date payDate, boolean payStatus, String payMethod) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.orderRecipient = orderRecipient;
        this.payPrice = payPrice;
        this.payDate = payDate;
        this.payStatus = payStatus;
        this.payMethod = payMethod;
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

    public int getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(int payPrice) {
        this.payPrice = payPrice;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public boolean isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(boolean payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", userId='" + userId + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                ", payPrice=" + payPrice +
                ", payDate=" + payDate +
                ", payStatus=" + payStatus +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
