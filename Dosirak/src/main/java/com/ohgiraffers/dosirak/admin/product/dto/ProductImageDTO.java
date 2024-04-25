package com.ohgiraffers.dosirak.admin.product.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@Setter
@ToString
public class ProductImageDTO {

    private int imgCode;
    private int ProductCode;
    private String savedName;
    private String savePath;

    public ProductImageDTO() {}

    public ProductImageDTO(int imgCode, int productCode, String savedName, String savePath) {
        this.imgCode = imgCode;
        ProductCode = productCode;
        this.savedName = savedName;
        this.savePath = savePath;
    }


    public ProductImageDTO(productDTO lastProduct, String saveFileName, List<MultipartFile> productImage) {
    }
}
