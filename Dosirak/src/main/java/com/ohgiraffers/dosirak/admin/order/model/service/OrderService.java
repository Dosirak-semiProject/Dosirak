package com.ohgiraffers.dosirak.admin.order.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dao.OrderMapper;
import com.ohgiraffers.dosirak.admin.order.model.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderMapper orderMapper;

    public OrderService(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<OrderDTO> allOrderLists() {
        return orderMapper.allOrderLists();
    }

    public List<RefundDTO> allRefundList() {
        return orderMapper.allRefundList();
    }

    public List<ShippingDTO> allShippingList() {
        return orderMapper.allShippingList();
    }

    public List<OrderViewDTO> allOrderView() {
        return orderMapper.allOrderView();
    }

}
