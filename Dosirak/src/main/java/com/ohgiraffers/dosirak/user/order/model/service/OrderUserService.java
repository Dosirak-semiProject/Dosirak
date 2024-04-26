package com.ohgiraffers.dosirak.user.order.model.service;

import com.ohgiraffers.dosirak.user.order.model.dao.OrderUserMapper;
import com.ohgiraffers.dosirak.user.order.model.dto.OrderDTO;
import org.springframework.stereotype.Service;

@Service
public class OrderUserService {

    private OrderUserMapper orderUserMapper;
    public OrderDTO orderCall() {
        return orderUserMapper.orderCall();
    }
}
