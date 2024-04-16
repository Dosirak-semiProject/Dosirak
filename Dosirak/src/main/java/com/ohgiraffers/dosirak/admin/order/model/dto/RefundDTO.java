package com.ohgiraffers.dosirak.admin.order.model.dto;


import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;

import java.time.LocalDate;

public class RefundDTO {

    private String refundCode;
    private int refundPrice;
    private LocalDate refundDate;
    private char refundStatus;
    private MemberDTO memberDTO;
    private PayDTO payDTO;
    private String orderCode;

    public RefundDTO() {}

    public RefundDTO(String refundCode, int refundPrice, LocalDate refundDate, char refundStatus, MemberDTO memberDTO, PayDTO payDTO, String orderCode) {
        this.refundCode = refundCode;
        this.refundPrice = refundPrice;
        this.refundDate = refundDate;
        this.refundStatus = refundStatus;
        this.memberDTO = memberDTO;
        this.payDTO = payDTO;
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

    public char getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(char refundStatus) {
        this.refundStatus = refundStatus;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public PayDTO getPayDTO() {
        return payDTO;
    }

    public void setPayDTO(PayDTO payDTO) {
        this.payDTO = payDTO;
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
                ", refundStatus=" + refundStatus +
                ", memberDTO=" + memberDTO +
                ", payDTO=" + payDTO +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
