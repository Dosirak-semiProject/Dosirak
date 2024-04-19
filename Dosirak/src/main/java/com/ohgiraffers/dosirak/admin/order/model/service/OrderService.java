package com.ohgiraffers.dosirak.admin.order.model.service;

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

        List<OrderDTO> orderDTO = orderMapper.allOrderLists();

        for (OrderDTO order : orderDTO) {

            order.getPay().setPayStatus(order.getPay().getPayStatus());
            order.setOrderStatus(order.getOrderStatus());

            if (order.getPay().getPayStatus() != null) {
                switch (order.getPay().getPayStatus() + "") {
                    case "C":
                        order.getPay().setPayStatus("결제완료");
                        break;
                    case "F":
                        order.getPay().setPayStatus("결제실패");
                        break;
                    case "X":
                        order.getPay().setPayStatus("결제취소");
                        break;
                    default:
                        order.getPay().setPayStatus("PayStatus Error");
                }
            }
            if (order.getOrderStatus() != null) {
                switch (order.getOrderStatus() + "") {
                    case "O":
                        order.setOrderStatus("주문완료");
                        break;
                    case "X":
                        order.setOrderStatus("주문취소");
                        break;
                    case "C":
                        order.setOrderStatus("구매확정");
                        break;
                    default:
                        order.setOrderStatus("OrderStatus Error");
                }
            }
        }
        return orderDTO;
    }

    public List<RefundDTO> allRefundList() {
        List<RefundDTO> refundDTO = orderMapper.allRefundList();

        for (RefundDTO refund : refundDTO) {
            refund.setRefundStatus(refund.getRefundStatus());

            if (refund.getRefundStatus() != null) {
                switch (refund.getRefundStatus()) {
                    case "R":
                        refund.setRefundStatus("환불요청");
                        break;
                    case "P":
                        refund.setRefundStatus("환불처리중");
                        break;
                    case "A":
                        refund.setRefundStatus("환불승인");
                        break;
                    case "D":
                        refund.setRefundStatus("환불거부");
                        break;
                }
            }
        }

        return refundDTO;
    }

    public List<DeliveryDTO> allDeliveryList() {
        return orderMapper.allDeliveryList();
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

        if (orderDTO.getOrderStatus() != null) {
            switch (orderDTO.getOrderStatus()) {
                case "O":
                    orderDTO.setOrderStatus("주문완료");
                    break;
                case "X":
                    orderDTO.setOrderStatus("주문취소");
                    break;
                case "C":
                    orderDTO.setOrderStatus("구매확정");
                    break;
                default:
                    orderDTO.setOrderStatus("OrderStatus Error");
            }
        }

        return orderDTO;
    }

    public RefundDTO allRefundView(String orderCode) {

        RefundDTO refundDTO = orderMapper.allRefundView(orderCode);

        if (refundDTO.getRefundStatus() != null) {
            switch (refundDTO.getRefundStatus() + "") {
                case "R":
                    refundDTO.setRefundStatus("환불요청");
                    break;
                case "P":
                    refundDTO.setRefundStatus("환불처리중");
                    break;
                case "A":
                    refundDTO.setRefundStatus("환불승인");
                    break;
                case "D":
                    refundDTO.setRefundStatus("환불거부");
                    break;
                default:
                    refundDTO.setRefundStatus("환불미요청");
            }
        }

        return refundDTO;
    }

    public DeliveryDTO allDeliveryView(String orderCode) {
        return orderMapper.allDeliveryView(orderCode);
    }
}
