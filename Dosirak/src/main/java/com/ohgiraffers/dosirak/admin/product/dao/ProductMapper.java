package com.ohgiraffers.dosirak.admin.product.dao;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    List<productDTO> findAllProduct();
    

    List<productDTO> insertProduction(productDTO product);


    List<productDTO> productSelectList(String key);


    productDTO getProductByCode(int productCode);
}
