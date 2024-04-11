package com.ohgiraffers.dosirak.admin.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
public class OrderController {

    @GetMapping("orderList")
    public String orderList() {return "admin/order/orderList";}

    @GetMapping("orderView")
    public String orderView() {return "admin/order/orderView";}

    @GetMapping("refundList")
    public String refundList() {return "admin/order/refundList";}

    @GetMapping("refundView")
    public String refundView() {return "admin/order/refundView";}

    @GetMapping("shippingList")
    public String shippingList() {return "admin/order/shippingList";}

    @GetMapping("shippingView")
    public String shippingView() {return "admin/order/shippingView";}
}
