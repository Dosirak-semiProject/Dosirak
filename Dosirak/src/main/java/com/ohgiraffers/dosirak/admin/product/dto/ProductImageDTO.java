package com.ohgiraffers.dosirak.admin.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductImageDTO {

    private int imgCode;
    private int ProductCode;
    private String savedName;
    private String savePath;

    public ProductImageDTO() {}

}
