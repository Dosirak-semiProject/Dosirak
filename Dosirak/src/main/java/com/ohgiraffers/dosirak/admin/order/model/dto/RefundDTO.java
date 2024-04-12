package com.ohgiraffers.dosirak.admin.order.model.dto;


import java.time.LocalDate;

public class RefundDTO {

    private String orderCode;
    private int refundPrice;
    private LocalDate refundDate;
    private String refundStatus;
    private String userName;
    private String userId;
    private String payMethod;

    public RefundDTO() {}

    public RefundDTO(String orderCode, int refundPrice, LocalDate refundDate, String refundStatus, String userName, String userId, String payMethod) {
        this.orderCode = orderCode;
        this.refundPrice = refundPrice;
        this.refundDate = refundDate;
        this.refundStatus = refundStatus;
        this.userName = userName;
        this.userId = userId;
        this.payMethod = payMethod;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(int refundPrice) {
        this.refundPrice = refundPrice;
    }

    public LocalDate getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(LocalDate refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
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

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    @Override
    public String toString() {
        return "RefundDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", refundAmount=" + refundPrice +
                ", refundDate=" + refundDate +
                ", refundStatus='" + refundStatus + '\'' +
                ", userName='" + userName + '\'' +
                ", userId='" + userId + '\'' +
                ", payMethod='" + payMethod + '\'' +
                '}';
    }
}
