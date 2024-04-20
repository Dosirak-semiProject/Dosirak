package com.ohgiraffers.dosirak.user.order.controller;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.PayDTO;
import com.ohgiraffers.dosirak.admin.order.model.service.OrderService;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.order.model.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/*")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /* 회원 아이디 주소창에 넘겨 받아야 됨 */
    @GetMapping("cart")
    public String cart(Model model, @RequestParam String id) {

        List<CartDTO> cartDTO = cartService.cartListView();
        PayDTO payDTO = cartService.payListView();

        model.addAttribute("cartDTO", cartDTO);
        model.addAttribute("payDTO", payDTO);

        return "/user/order/cart";
    }
}
