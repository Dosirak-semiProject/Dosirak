package com.ohgiraffers.dosirak.admin.order.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeliveryDTO {

    String orderCode;
    String deliveryCode;
    String deliveryStatus;
    String orderRecipient;

    public DeliveryDTO() {}

    public DeliveryDTO(String orderCode, String deliveryCode, String deliveryStatus, String orderRecipient) {
        this.orderCode = orderCode;
        this.deliveryCode = deliveryCode;
        this.deliveryStatus = deliveryStatus;
        this.orderRecipient = orderRecipient;
    }
}
