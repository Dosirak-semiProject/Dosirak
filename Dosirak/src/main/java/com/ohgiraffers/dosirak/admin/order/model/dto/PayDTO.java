package com.ohgiraffers.dosirak.admin.order.model.dto;

import java.time.LocalDate;
import java.util.List;

public class PayDTO {
    private int  payPrice;
    private LocalDate payDate;
    private boolean payStatus;
    private String payMethod;
    private String orderCode;

    public PayDTO() {}

    public PayDTO(int payPrice, LocalDate payDate, boolean payStatus, String payMethod, String orderCode) {
        this.payPrice = payPrice;
        this.payDate = payDate;
        this.payStatus = payStatus;
        this.payMethod = payMethod;
        this.orderCode = orderCode;
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "PayDTO{" +
                "payPrice=" + payPrice +
                ", payDate=" + payDate +
                ", payStatus=" + payStatus +
                ", payMethod='" + payMethod + '\'' +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
