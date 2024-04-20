package com.ohgiraffers.dosirak.user.order.model.service;

import com.ohgiraffers.dosirak.admin.order.model.dto.PayDTO;
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

    public List<CartDTO> cartListView() {
        return cartMapper.cartListView();
    }

    public PayDTO payListView() {
        return cartMapper.payListView();
    }
}
