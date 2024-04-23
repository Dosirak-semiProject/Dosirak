package com.ohgiraffers.dosirak.user.product.controller;


import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.product.dto.ProductUserDTO;
import com.ohgiraffers.dosirak.user.product.service.ProductUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        return "/user/product/productUserView";


    }

    @GetMapping("/productListJungsung")
    public String productListJungsung(Model model) {
        int categoryCode = 2;
        ProductUserDTO productList = productUserService.productsListView(categoryCode);
        model.addAttribute("productList", productList);
        return "/user/product/productListJungsung";


    }

    @GetMapping("/productListHel")
    public String productListHel(Model model) {
        List<ProductUserDTO> productList = productUserService.getProductListBySubCategoryCode(1);
        model.addAttribute("productList", productList);
        return "/user/product/productListHel";
    }

    @GetMapping("/productListComp")
    public String productListComp(Model model) {
        List<ProductUserDTO> productList = productUserService.getProductListBySubCategoryCode(3);
        model.addAttribute("productList", productList);
        return "/user/product/productListComp";


    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam Map<String, Object> requestData) {
        int productCode = (int) requestData.get("productCode");
        int cartitemCount = (int) requestData.get("cartitemCount");
        int totalPrice = (int) requestData.get("totalPrice");

        String list = productUserService.addCart(productCode, cartitemCount, totalPrice);
        System.out.println(list);
        System.out.println("여기까진옴");

        return "/user/order/cart";
    }
}
