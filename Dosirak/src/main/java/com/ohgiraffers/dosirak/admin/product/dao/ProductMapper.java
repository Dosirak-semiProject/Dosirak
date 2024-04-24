package com.ohgiraffers.dosirak.admin.product.dao;

import com.ohgiraffers.dosirak.admin.product.dto.ProductImageDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<productDTO> findAllProduct();
    

    int insertProduction(productDTO product);


    List<productDTO> productSelectList(String key);


    productDTO getProductByCode(int productCode);


    int productUpdate(productDTO product);

    void insertImage(ProductImageDTO fileInfo);


    productDTO codePlz();
}
