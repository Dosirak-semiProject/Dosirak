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

    //    파라미터 넘긴 방식이 Get 인데 PostMapping 되어있었음
//    html 링크에서 /admin 명시 안되어있음
//    view페이지 오류 ex) 찾을수없는값 있을경우
    @GetMapping("/productView")
    public String productView(@RequestParam int productCode, Model model) {
        System.out.println(productCode);
        productDTO product = productService.getProductByCode(productCode);
        model.addAttribute("product", product);
        System.out.println(product);
        return "/admin/product/productView";
    }

    @GetMapping("/nullProductView")
    public String getProductViewPage() {
        return "/admin/product/nullProductView";
    }

    @PostMapping("/updateProduct")
    @ResponseBody
    public String productUpdate(@RequestBody productDTO product) {
        productService.productUpdate(product);
        return "/admin/product/productList";


    }
}
