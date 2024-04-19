package com.ohgiraffers.dosirak.admin.order.model.dto;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DetailDTO {
    private String orderCode;
    private String detailCode;
    private int detailItemCount;
    private String detailItemCode;
    private productDTO product;

    public DetailDTO() {}

    public DetailDTO(String orderCode, String detailCode, int detailItemCount, String detailItemCode, productDTO product) {
        this.orderCode = orderCode;
        this.detailCode = detailCode;
        this.detailItemCount = detailItemCount;
        this.detailItemCode = detailItemCode;
        this.product = product;
    }
}
