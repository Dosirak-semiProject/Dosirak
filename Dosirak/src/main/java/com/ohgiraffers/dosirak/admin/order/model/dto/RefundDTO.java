package com.ohgiraffers.dosirak.admin.order.model.dto;


import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;

import java.time.LocalDate;

public class RefundDTO {

    private String refundCode;
    private int refundPrice;
    private LocalDate refundDate;
    private String refundStatus;
    private MemberDTO member;
    private PayDTO pay;
    private String orderCode;

    public RefundDTO() {}

    public RefundDTO(String refundCode, int refundPrice, LocalDate refundDate, String refundStatus, MemberDTO member, PayDTO pay, String orderCode) {
        this.refundCode = refundCode;
        this.refundPrice = refundPrice;
        this.refundDate = refundDate;
        this.refundStatus = refundStatus;
        this.member = member;
        this.pay = pay;
        this.orderCode = orderCode;
    }

    public String getRefundCode() {
        return refundCode;
    }

    public void setRefundCode(String refundCode) {
        this.refundCode = refundCode;
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

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public PayDTO getPay() {
        return pay;
    }

    public void setPay(PayDTO pay) {
        this.pay = pay;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "RefundDTO{" +
                "refundCode='" + refundCode + '\'' +
                ", refundPrice=" + refundPrice +
                ", refundDate=" + refundDate +
                ", refundStatus='" + refundStatus + '\'' +
                ", member=" + member +
                ", pay=" + pay +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
