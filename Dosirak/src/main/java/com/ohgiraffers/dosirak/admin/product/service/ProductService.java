package com.ohgiraffers.dosirak.admin.product.service;

import com.ohgiraffers.dosirak.admin.product.dao.ProductMapper;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.common.product.ProductUpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<productDTO> findAllProduct() {
        return productMapper.findAllProduct();
    }


    public void insertProduction(productDTO product) {

        productMapper.insertProduction(product);
    }


    public List<productDTO> productSelectList(String key) {
        return productMapper.productSelectList(key);
    }


    public productDTO getProductByCode(int productCode) {
        return productMapper.getProductByCode(productCode);
    }

    @Transactional
    public void productUpdate(productDTO product) throws ProductUpdateException{
      int result=  productMapper.productUpdate(product);
        if(!(result > 0)) throw new ProductUpdateException("수정에 실패하였습니다.");


    }

    public void deleteProduct(productDTO product) {
        productMapper.deleteProduct(product);
    }
}

