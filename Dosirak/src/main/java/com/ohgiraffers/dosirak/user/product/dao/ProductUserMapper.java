package com.ohgiraffers.dosirak.user.product.dao;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductUserMapper {
    List<productDTO> findAllUserProduct();

    ProductUserDTO viewProduct(int productCode);

    ProductUserDTO productsListViewNomal(int categoryCode);

    ProductUserDTO productsListView(int categoryCode);

    ProductUserDTO productsListView3();


    List<ProductUserDTO> getProductListBySubCategoryCode(int subCategoryCode);

    List<CartDTO> addCart();
}
