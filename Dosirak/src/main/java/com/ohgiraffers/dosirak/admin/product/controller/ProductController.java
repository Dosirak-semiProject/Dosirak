package com.ohgiraffers.dosirak.admin.product.controller;

import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.admin.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product/*")
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
    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute productDTO product, Model model) {
        List<productDTO>insertProduction= productService.insertProduction(product); // ProductService에 해당 메소드를 구현해야 함
        model.addAttribute("insertProduction",insertProduction);
        return "redirect:/admin/product/productList"; // 상품 목록 페이지로 리다이렉트
    }
    @GetMapping("/productView")
    public String productView(Model model){
        List<productDTO> productView=productService.viewProduct();
        model.addAttribute("productView",productView);
        return "/admin/product/productView";
    }



}
