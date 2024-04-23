package com.ohgiraffers.dosirak.user.order.controller;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.order.model.service.CartService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/*")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("cart")
    public String cart(Model model) {
        /* 현재 인증된 사용자 아이디 가져오기 */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userID = authentication.getName();
        System.out.println("아이디 조회 = " + userID);
        List<CartDTO> cartDTO = cartService.userCartList(userID);
//        for (CartDTO cart : cartDTO) {
//            System.out.println("장바구니 조회: " + cart.getCartitemCount());
//            System.out.println("장바구니 조회: " + cart.getProductDTO().getProductName());
//            System.out.println("장바구니 조회: " + cart.getProductDTO().getProductPrice());
//        }
        model.addAttribute("cartDTO", cartDTO);
        return "/user/order/cart";
    }

    @GetMapping("payment")
    public String payment(Model model, @RequestParam String id) {

        List<CartDTO> cartDTO = cartService.userPayment(id);

        model.addAttribute("cartDTO", cartDTO);

        return "/user/order/payment";
    }

    @GetMapping("orderDone")
    public String orderDone(Model model, @RequestParam String id) {

        List<OrderDTO> orderDTO = cartService.userOrderDone(id);

        model.addAttribute("orderDTO", orderDTO);

        return "/user/order/orderDone";
    }
}
