package com.ohgiraffers.dosirak.user.order.model.dao;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.OrderDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.user.order.model.dto.CartDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CartMapper {
    List<CartDTO> userCartList(String userId);

    List<OrderDTO> userOrderDone(String userId);

    List<CartDTO> userPayment(String userId);

    void cartUpdateQuantity(int productCode, int updatedQuantity);

    int cartTotalPrice(Map<String, Integer> cart);

//    MemberDTO findMemberList();
}
