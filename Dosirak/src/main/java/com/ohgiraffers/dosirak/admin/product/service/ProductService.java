package com.ohgiraffers.dosirak.admin.product.service;

import com.ohgiraffers.dosirak.admin.product.dao.ProductMapper;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<productDTO> findAllProduct() {
        return productMapper.findAllProduct();
    }


    public List<productDTO> insertProduction(productDTO product) {

        return productMapper.insertProduction(product);
    }


    public List<productDTO> productSelectList(String key) {
        return productMapper.productSelectList(key);
    }


    public productDTO getProductByCode(int productCode) {
        return productMapper.getProductByCode(productCode);
    }

    public List<productDTO> productUpdate(productDTO product) {
        return productMapper.productUpdate(product);
    }
}

