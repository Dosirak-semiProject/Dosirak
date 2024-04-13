package com.ohgiraffers.dosirak.admin.order.model.service;

import com.ohgiraffers.dosirak.admin.order.model.dao.OrderMapper;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.RefundDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.ShippingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> AllOrderList() {
        return orderMapper.AllOrderList();
    }

    public List<RefundDTO> AllRefundList() {
        return orderMapper.AllRefundList();
    }

    public List<ShippingDTO> AllShippingList() {
        return orderMapper.AllShippingList();
    }
}
