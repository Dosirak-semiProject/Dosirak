package com.ohgiraffers.dosirak.user.order.model.service;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.user.order.model.dao.CartMapper;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class CartService {

    private final CartMapper cartMapper;

    public CartService(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    public List<CartDTO> userCartList() {
        return cartMapper.userCartList();
    }

    public List<OrderDTO> userOrderDone() {
        return cartMapper.userOrderDone();
    }

    public List<CartDTO> userPayment() {
        return cartMapper.userPayment();
    }
}
