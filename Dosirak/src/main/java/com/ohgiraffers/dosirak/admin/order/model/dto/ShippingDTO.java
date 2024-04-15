package com.ohgiraffers.dosirak.admin.order.model.dto;

public class ShippingDTO {

    String orderCode;
    String deliveryCode;
    String deliveryStatus;
    String orderRecipient;

    public ShippingDTO() {}

    public ShippingDTO(String orderCode, String deliveryCode, String deliveryStatus, String orderRecipient) {
        this.orderCode = orderCode;
        this.deliveryCode = deliveryCode;
        this.deliveryStatus = deliveryStatus;
        this.orderRecipient = orderRecipient;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(String deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getOrderRecipient() {
        return orderRecipient;
    }

    public void setOrderRecipient(String orderRecipient) {
        this.orderRecipient = orderRecipient;
    }

    @Override
    public String toString() {
        return "ShippingDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", deliveryCode='" + deliveryCode + '\'' +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", orderRecipient='" + orderRecipient + '\'' +
                '}';
    }
}
