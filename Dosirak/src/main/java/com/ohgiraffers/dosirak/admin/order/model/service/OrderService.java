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

    public OrderDTO allOrderView(String orderCode) {
        OrderDTO orderDTO = orderMapper.allOrderView(orderCode);

        if (orderDTO == null) {
            return null;
        }

        if (orderDTO.getRefund().getRefundStatus() != null || orderDTO.getRefund().getRefundStatus() == null) {
            switch (orderDTO.getRefund().getRefundStatus() + "") {
                case "R":
                    orderDTO.getRefund().setRefundStatus("환불요청");
                    break;
                case "P":
                    orderDTO.getRefund().setRefundStatus("환불처리중");
                    break;
                case "A":
                    orderDTO.getRefund().setRefundStatus("환불승인");
                    break;
                case "D":
                    orderDTO.getRefund().setRefundStatus("환불거부");
                    break;
                default:
                    orderDTO.getRefund().setRefundStatus("환불미요청");
            }
        }

        return orderDTO;
    }

}
