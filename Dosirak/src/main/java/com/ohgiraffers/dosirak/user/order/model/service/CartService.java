package com.ohgiraffers.dosirak.user.order.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dao.CartMapper;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.IllegalFormatCodePointException;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> userCartList(String userID) {
        return cartMapper.userCartList(userID);
    }

    public List<OrderDTO> userOrderDone(String id) {
        return cartMapper.userOrderDone(id);
    }

    public List<CartDTO> userPayment(String id) {
        return cartMapper.userPayment(id);
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

    public List<MemberDTO> findSearchId() {
        return cartMapper.findSearchId();
    }
}
