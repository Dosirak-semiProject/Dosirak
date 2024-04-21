package com.ohgiraffers.dosirak.user.order.controller;

import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.order.model.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/*")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("cart/update-quantity")
    public String cartUpdateQuantity(@RequestBody CartDTO cartDTO) {

        cartService.cartUpdateQuantity(cartDTO);

        return "redirect:/user/order/cart";
    }
}
