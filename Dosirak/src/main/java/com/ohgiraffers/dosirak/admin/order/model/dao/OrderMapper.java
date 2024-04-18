package com.ohgiraffers.dosirak.admin.order.model.dao;

import com.ohgiraffers.dosirak.admin.order.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> allOrderLists();

    List<RefundDTO> allRefundList();

    List<DeliveryDTO> allDeliveryList();

    OrderDTO allOrderView(String orderCode);

    RefundDTO allRefundView(String orderCode);
}
