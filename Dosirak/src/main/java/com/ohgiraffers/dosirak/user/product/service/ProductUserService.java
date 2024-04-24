package com.ohgiraffers.dosirak.user.product.service;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dao.CartMapper;
import com.ohgiraffers.dosirak.user.order.model.dao.OrderUserMapper;
import com.ohgiraffers.dosirak.user.product.dao.ProductUserMapper;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductUserService {
    @Autowired
    private ProductUserMapper productUserMapper;
    @Autowired
    private CartMapper cartMapper;
    public List<productDTO> findAllProduct() {
        return productUserMapper.findAllUserProduct();
    }

    public ProductUserDTO viewProduct(int productCode) {
        return productUserMapper.viewProduct(productCode);
    }


    public ProductUserDTO productsListViewNomal(int categoryCode) {
        return productUserMapper.productsListViewNomal(categoryCode);
    }

    public ProductUserDTO productsListView(int categoryCode) {
        return productUserMapper.productsListView(categoryCode);
    }



    public List<ProductUserDTO> getProductListBySubCategoryCode(int subCategoryCode) {
        return productUserMapper.getProductListBySubCategoryCode(subCategoryCode);
    }


    public int addCart(Map<String, String> productInfo) {
        return productUserMapper.addCart(productInfo);
    }
}
