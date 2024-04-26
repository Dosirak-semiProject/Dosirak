package com.ohgiraffers.dosirak.user.order.model.dao;

import com.ohgiraffers.dosirak.user.order.model.dto.OrderDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderUserMapper {
    OrderDTO orderCall();
}
