package com.ohgiraffers.dosirak.user.order.controller;

import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import com.ohgiraffers.dosirak.user.order.model.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user/*")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("cart/update-quantity")
    public ResponseEntity<Map<String, Object>> cartUpdateQuantity(@RequestBody CartDTO cartDTO) {
        Map<String, Object> response = new HashMap<>();
        try {

            /* 수량 업데이트 */
            cartService.cartUpdateQuantity(cartDTO);

            /* 단일 합계 계산 */
            int singleTotalPrice = cartService.cartTotalPrice(cartDTO);

            /* 단일 합계 계산 */
//            int TotalPrice = cartService.cartAllTotalPrice(cartDTO.getId());

            response.put("success", true);
            response.put("message", "수량이 업데이트 되었습니다.");
            response.put("singleTotalPrices", singleTotalPrice);
//            response.put("totalPrice", TotalPrice);

            return ResponseEntity.ok(response);
        } catch (Exception e) {

            response.put("success", false);
            response.put("message", "수량 업데이트 중 오류 발생");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("payment/kakao-pay")
    public String paymentKakaoPay() {return null;}
}
