package com.ohgiraffers.dosirak.user.order.controller;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.order.model.service.CartService;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String cart(Model model) {

        List<CartDTO> cartDTO = cartService.userCartList();

        model.addAttribute("cartDTO", cartDTO);

        return "/user/order/cart";
    }

    @GetMapping("payment")
    public String payment(Model model) {

        List<CartDTO> cartDTO = cartService.userPayment();

        model.addAttribute("cartDTO", cartDTO);

        return "/user/order/payment";
    }

    /* 회원 아이디 주소창에 넘겨 받아야 됨 */
    @GetMapping("orderDone")
    public String orderDone(Model model) {

        List<OrderDTO> orderDTO = cartService.userOrderDone();

        model.addAttribute("orderDTO", orderDTO);

        return "/user/order/orderDone";
    }
}
