package com.ohgiraffers.dosirak.admin.order.controller;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.RefundDTO;
import com.ohgiraffers.dosirak.admin.order.model.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orderList")
    public String orderList(Model model) {

        List<OrderDTO> orderList = orderService.AllOrderList();

        model.addAttribute("orderList", orderList);

        return "admin/order/orderList";
    }

    @GetMapping("orderView")
    public String orderView() {return "admin/order/orderView";}

    @GetMapping("refundList")
    public String refundList(Model model) {

        List<RefundDTO> refundList = orderService.AllRefundList();

        model.addAttribute("refundList", refundList);

        return "admin/order/refundList";
    }

    @GetMapping("refundView")
    public String refundView() {return "admin/order/refundView";}

    @GetMapping("shippingList")
    public String shippingList() {return "admin/order/shippingList";}

    @GetMapping("shippingView")
    public String shippingView() {return "admin/order/shippingView";}
}
