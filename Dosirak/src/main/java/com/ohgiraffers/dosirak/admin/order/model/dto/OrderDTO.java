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
    private PayDTO payDTOList;
    private MemberDTO memberDTOList;
    private List<DetailDTO> detailDTOList;

    public OrderDTO() {}

    public OrderDTO(String orderCode, String orderStatus, String orderRecipient, String orderConcat, String orderAddress, PayDTO payDTOList, MemberDTO memberDTOList, List<DetailDTO> detailDTOList) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.orderRecipient = orderRecipient;
        this.orderConcat = orderConcat;
        this.orderAddress = orderAddress;
        this.payDTOList = payDTOList;
        this.memberDTOList = memberDTOList;
        this.detailDTOList = detailDTOList;
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

    public PayDTO getPayDTOList() {
        return payDTOList;
    }

    public void setPayDTOList(PayDTO payDTOList) {
        this.payDTOList = payDTOList;
    }

    public MemberDTO getMemberDTOList() {
        return memberDTOList;
    }

    public void setMemberDTOList(MemberDTO memberDTOList) {
        this.memberDTOList = memberDTOList;
    }

    public List<DetailDTO> getDetailDTOList() {
        return detailDTOList;
    }

    public void setDetailDTOList(List<DetailDTO> detailDTOList) {
        this.detailDTOList = detailDTOList;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                ", orderConcat='" + orderConcat + '\'' +
                ", orderAddress='" + orderAddress + '\'' +
                ", payDTOList=" + payDTOList +
                ", memberDTOList=" + memberDTOList +
                ", detailDTOList=" + detailDTOList +
                '}';
    }
}
