package com.ohgiraffers.dosirak.admin.order.model.dto;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.product.dto.categoryDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;

import java.util.List;

public class OrderDTO {

    private String orderCode;
    private String orderStatus;
    private String orderRecipient;
    private String orderConcat;
    private String orderAddress;
    private PayDTO pay;
    private MemberDTO member;
    private RefundDTO refund;
    private ShippingDTO shipping;
    private List<DetailDTO> detail;

    public OrderDTO() {}

    public OrderDTO(String orderCode, String orderStatus, String orderRecipient, String orderConcat, String orderAddress, PayDTO pay, MemberDTO member, RefundDTO refund, ShippingDTO shipping, List<DetailDTO> detail) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.orderRecipient = orderRecipient;
        this.orderConcat = orderConcat;
        this.orderAddress = orderAddress;
        this.pay = pay;
        this.member = member;
        this.refund = refund;
        this.shipping = shipping;
        this.detail = detail;
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

    public String getOrderRecipient() {
        return orderRecipient;
    }

    public void setOrderRecipient(String orderRecipient) {
        this.orderRecipient = orderRecipient;
    }

    public String getOrderConcat() {
        return orderConcat;
    }

    public void setOrderConcat(String orderConcat) {
        this.orderConcat = orderConcat;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public PayDTO getPay() {
        return pay;
    }

    public void setPay(PayDTO pay) {
        this.pay = pay;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public RefundDTO getRefund() {
        return refund;
    }

    public void setRefund(RefundDTO refund) {
        this.refund = refund;
    }

    public ShippingDTO getShipping() {
        return shipping;
    }

    public void setShipping(ShippingDTO shipping) {
        this.shipping = shipping;
    }

    public List<DetailDTO> getDetail() {
        return detail;
    }

    public void setDetail(List<DetailDTO> detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                ", orderConcat='" + orderConcat + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", pay=" + pay +
                ", member=" + member +
                ", refund=" + refund +
                ", shipping=" + shipping +
                ", detail=" + detail +
                '}';
    }
}
