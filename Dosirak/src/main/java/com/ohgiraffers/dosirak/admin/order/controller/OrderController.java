package com.ohgiraffers.dosirak.admin.order.controller;

import com.ohgiraffers.dosirak.admin.order.model.dto.*;
import com.ohgiraffers.dosirak.admin.order.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orderList")
    public String orderList(Model model) {

        List<OrderDTO> orderLists = orderService.allOrderLists();

        model.addAttribute("orderLists", orderLists);

        return "admin/order/orderList";
    }

    @GetMapping("orderView")
    public String orderView(Model model, @RequestParam String orderCode) {

        OrderDTO orderView = orderService.allOrderView(orderCode);

        model.addAttribute("orderView", orderView);

        return "admin/order/orderView";
    }

    @GetMapping("refundList")
    public String refundList(Model model) {

        List<RefundDTO> refundLists = orderService.allRefundList();

        model.addAttribute("refundLists", refundLists);

        return "admin/order/refundList";
    }

    @GetMapping("refundView")
    public String refundView(Model model, @RequestParam String orderCode) {

        RefundDTO refundView = orderService.allRefundView(orderCode);

        model.addAttribute("refundView", refundView);

        return "admin/order/refundView";
    }

    @GetMapping("deliveryList")
    public ModelAndView deliveryList(ModelAndView mv) {

        List<DeliveryDTO> deliveryList = orderService.allDeliveryList();

        mv.addObject("deliveryList", deliveryList);

        mv.setViewName("admin/order/deliveryList");

        return mv;
    }

    @GetMapping("deliveryView")
    public ModelAndView shippingView(ModelAndView mv, @RequestParam String orderCode) {

        DeliveryDTO deliveryView = orderService.allDeliveryView(orderCode);

        mv.addObject("deliveryView", deliveryView);

        mv.setViewName("admin/order/deliveryView");

        System.out.println("@@@@@@@@@@@@@@" + deliveryView.getOrder().getOrderCode());

        return mv;
    }
}
