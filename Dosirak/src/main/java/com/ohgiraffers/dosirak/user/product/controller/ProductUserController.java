package com.ohgiraffers.dosirak.user.product.controller;


import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.admin.product.service.ProductService;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import com.ohgiraffers.dosirak.user.product.service.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/product/*")

public class ProductUserController {

    private final ProductUserService productUserService;

    @Autowired
    public ProductUserController(ProductUserService productUserService) {
        this.productUserService = productUserService;
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        List<productDTO> productList = productUserService.findAllProduct();
        model.addAttribute("productList", productList);
        return "/user/product/productList";
    }

    @GetMapping("/productView")
    public String productView(@RequestParam int productCode, Model model) {
        ProductUserDTO productList = productUserService.viewProduct(productCode);
        model.addAttribute("productList", productList);
        return "/user/product/productView";


    }
    @GetMapping("/productsList")
    public String productsListView(@RequestParam int categoryCode, Model model) {
        ProductUserDTO productList = productUserService.productsListView(categoryCode);
        model.addAttribute("productList", productList);
        return "/user/product/productList";


    }


}
