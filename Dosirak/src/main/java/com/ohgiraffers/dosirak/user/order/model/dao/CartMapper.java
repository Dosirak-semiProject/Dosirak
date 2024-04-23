package com.ohgiraffers.dosirak.user.order.model.dao;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CartMapper {
    List<CartDTO> userCartList(String userID);

    List<OrderDTO> userOrderDone(String id);

    List<CartDTO> userPayment(String id);

    void cartUpdateQuantity(int productCode, int updatedQuantity);

    List<MemberDTO> findSearchId();
}
