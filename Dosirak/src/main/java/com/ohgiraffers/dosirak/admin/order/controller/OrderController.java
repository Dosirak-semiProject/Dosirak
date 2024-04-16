package com.ohgiraffers.dosirak.admin.order.controller;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
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
    public OrderController(OrderService orderService, MemberService memberService) {
        this.orderService = orderService;
    }

    @GetMapping("orderList")
    public String orderList(Model model) {

        List<OrderDTO> orderLists = orderService.allOrderLists();

        model.addAttribute("orderLists", orderLists);

        return "admin/order/orderList";
    }

    @GetMapping("orderView")
    public String orderView(Model model) {

        List<OrderViewDTO> orderView = orderService.allOrderView();

        model.addAttribute("orderView", orderView);


        return "admin/order/orderView";
    }

    @GetMapping("refundList")
    public String refundList(Model model) {

        List<RefundDTO> refundLists = orderService.allRefundList();

        model.addAttribute("refundLists", refundLists);

        for (RefundDTO refundDTO : refundLists) {
            System.out.println("refundDTO = " + refundDTO);
        }

        return "admin/order/refundList";
    }

    @GetMapping("refundView")
    public String refundView() {return "admin/order/refundView";}

    @GetMapping("shippingList")
    public ModelAndView shippingList(ModelAndView mv) {

        List<ShippingDTO> shippingList = orderService.allShippingList();

        mv.addObject("shippingList", shippingList);

        mv.setViewName("admin/order/shippingList");

        return mv;
    }

    @GetMapping("shippingView")
    public String shippingView() {return "admin/order/shippingView";}
}
