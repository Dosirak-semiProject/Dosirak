package com.ohgiraffers.dosirak.user.order.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dao.CartMapper;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Transactional
public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> userCartList(String userId) {
        return cartMapper.userCartList(userId);
    }

    public List<OrderDTO> userOrderDone(String userId) {
        return cartMapper.userOrderDone(userId);
    }

    public List<CartDTO> userPayment(String userId) {
        return cartMapper.userPayment(userId);
    }

    public void cartUpdateQuantity(CartDTO cartDTO) {

        if (cartDTO != null) {
            int productCode = cartDTO.getProductCode();
            int updatedQuantity = cartDTO.getCartitemCount();

            cartMapper.cartUpdateQuantity(productCode, updatedQuantity);
        } else {
            System.out.println("productDTO가 null입니다. 요청을 확인하세요.");
        }
    }

    public int cartTotalPrice(CartDTO cartDTO) {
        Map<String , Integer> cart = new HashMap<>();
        cart.put("productCode", cartDTO.getProductCode());
        cart.put("cartitemCount", cartDTO.getCartitemCount());
        return cartMapper.cartTotalPrice(cart);
    }

//    public MemberDTO findMemberList() {
//        return cartMapper.findMemberList();
//    }

//    public int cartAllTotalPrice(String id) {
//        return cartMapper.cartAllTotalPrice(id);
//    }

//    public productDTO searchProductInfo() {
//        return cartMapper.searchProductInfo();
//    }
}
