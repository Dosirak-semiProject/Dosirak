package com.ohgiraffers.dosirak.admin.order.model.dto;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

public class OrderDTO {

    private String orderCode;
    private String orderStatus;
    private String userId;
    private String userName;
    private String orderRecipient;
    private int payPrice;
    private LocalDate payDate;
    private boolean payStatus;
    private String payMethod;

    public OrderDTO() {}

    public OrderDTO(String orderCode, String orderStatus, String userId, String userName, String orderRecipient, int payPrice, LocalDate payDate, boolean payStatus, String payMethod) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
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
                ", userName='" + userName + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                ", payPrice=" + payPrice +
                ", payDate=" + payDate +
                ", payStatus=" + payStatus +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
