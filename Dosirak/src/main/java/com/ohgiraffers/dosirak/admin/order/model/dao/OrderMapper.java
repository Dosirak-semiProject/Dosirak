package com.ohgiraffers.dosirak.admin.order.model.dao;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderViewDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.RefundDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.ShippingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> AllOrderList();

    List<RefundDTO> AllRefundList();

    List<ShippingDTO> AllShippingList();

    List<OrderViewDTO> AllOrderView();
}
