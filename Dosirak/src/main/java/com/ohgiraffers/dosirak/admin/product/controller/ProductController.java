package com.ohgiraffers.dosirak.admin.product.controller;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    private final ProductService productService;
    public ProductController(ProductService productService){
        this.productService=productService;

    }

    @GetMapping("/productList")
    public String productlist(Model model){
        List<productDTO> productList=productService.findAllProduct();
        model.addAttribute("productList",productList);
        return "/admin/product/productList";
    }
    @PostMapping("/product/search")
    public @ResponseBody String productselcetlist(@RequestParam String key,Model model){
        String productselcetlist=productService.productselcetlist(key);
        model.addAttribute("productselcetlist",productselcetlist);
        return key;
    }
}
