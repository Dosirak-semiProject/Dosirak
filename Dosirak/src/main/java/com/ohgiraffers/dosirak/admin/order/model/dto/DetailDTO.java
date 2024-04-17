package com.ohgiraffers.dosirak.admin.order.model.dto;

public class DetailDTO {
    private String orderCode;
    private String detailCode;
    private int detailItemCount;
    private String detailItemCode;
    private String suitBoxCode;

    DetailDTO() {}

    public DetailDTO(String orderCode, String detailCode, int detailItemCount, String detailItemCode, String suitBoxCode) {
        this.orderCode = orderCode;
        this.detailCode = detailCode;
        this.detailItemCount = detailItemCount;
        this.detailItemCode = detailItemCode;
        this.suitBoxCode = suitBoxCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getDetailCode() {
        return detailCode;
    }

    public void setDetailCode(String detailCode) {
        this.detailCode = detailCode;
    }

    public int getDetailItemCount() {
        return detailItemCount;
    }

    public void setDetailItemCount(int detailItemCount) {
        this.detailItemCount = detailItemCount;
    }

    public String getDetailItemCode() {
        return detailItemCode;
    }

    public void setDetailItemCode(String detailItemCode) {
        this.detailItemCode = detailItemCode;
    }

    public String getSuitBoxCode() {
        return suitBoxCode;
    }

    public void setSuitBoxCode(String suitBoxCode) {
        this.suitBoxCode = suitBoxCode;
    }

    @Override
    public String toString() {
        return "DetailDTO{" +
                "orderCode='" + orderCode + '\'' +
                ", detailCode='" + detailCode + '\'' +
                ", detailItemCount=" + detailItemCount +
                ", detailItemCode='" + detailItemCode + '\'' +
                ", suitBoxCode='" + suitBoxCode + '\'' +
                '}';
    }
}
