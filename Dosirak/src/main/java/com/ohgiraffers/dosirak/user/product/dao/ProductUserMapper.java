package com.ohgiraffers.dosirak.user.product.dao;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductUserMapper {
    List<productDTO> findAllUserProduct();

    ProductUserDTO viewProduct(int productCode);

    ProductUserDTO productsListView(List<Integer> categoryCode);

    ProductUserDTO productsListViewNomal(int categoryCode);
}
