package com.ohgiraffers.dosirak.user.product.service;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.product.dao.ProductUserMapper;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUserService {
    @Autowired
    private ProductUserMapper productUserMapper;
    public List<productDTO> findAllProduct() {
        return productUserMapper.findAllUserProduct();
    }

    public ProductUserDTO viewProduct(int productCode) {
        return productUserMapper.viewProduct(productCode);
    }

    public ProductUserDTO productsListView(int categoryCode) {
        return productUserMapper.productsListView(categoryCode);
    }
}
