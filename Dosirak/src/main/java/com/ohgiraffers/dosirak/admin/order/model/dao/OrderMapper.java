package com.ohgiraffers.dosirak.admin.order.model.dao;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderDTO> AllOrderList();

    List<OrderDTO> AllRefundList();
}
