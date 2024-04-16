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

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        List<productDTO> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "/admin/product/productList";
    }

    @PostMapping("/product/search")
    public String productSelectList(@RequestParam String key, Model model) {
        List<productDTO> productList = productService.productSelectList(key);
        model.addAttribute("productList", productList);
        return "/admin/product/productList";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute productDTO product) {
        productService.insertProduction(product);
        return "redirect:/admin/product/productList";
    }

    @PostMapping("/productViewSend")
    public String productView(@RequestParam String product, Model model) {
        String productlist = productService.productView(product);
        model.addAttribute("productlist", productlist);
        return "/admin/product/productView";
    }
    @GetMapping("/nullProductView")
    public String getProductViewPage() {
     return "/admin/product/nullProductView";
    }

}
