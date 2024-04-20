package com.ohgiraffers.dosirak.user.order.model.dao;

import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.PayDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> cartListView();

    PayDTO payListView();
}
