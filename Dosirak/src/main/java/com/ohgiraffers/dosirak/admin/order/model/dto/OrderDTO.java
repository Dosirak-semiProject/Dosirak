package com.ohgiraffers.dosirak.admin.order.model.dto;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OrderDTO {

    private String orderCode;
    private String orderStatus;
    private String orderRecipient;
    private String orderConcat;
    private String orderAddress;
    private PayDTO pay;
    private MemberDTO member;
    private RefundDTO refund;
    private DeliveryDTO delivery;
    private List<DetailDTO> detail;

    public OrderDTO() {}

    public OrderDTO(String orderCode, String orderStatus, String orderRecipient, String orderConcat, String orderAddress, PayDTO pay, MemberDTO member, RefundDTO refund, DeliveryDTO shipping, List<DetailDTO> detail) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.orderRecipient = orderRecipient;
        this.orderConcat = orderConcat;
        this.orderAddress = orderAddress;
        this.pay = pay;
        this.member = member;
        this.refund = refund;
        this.delivery = shipping;
        this.detail = detail;
    }
}
