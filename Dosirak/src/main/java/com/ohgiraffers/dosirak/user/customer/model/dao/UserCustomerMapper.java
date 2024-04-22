package com.ohgiraffers.dosirak.user.customer.model.dao;

import com.ohgiraffers.dosirak.user.customer.model.dto.UserAskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserCustomerImgDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserCustomerMapper {


    /* ----- 1대1 문의 ----- */
    void insertAttachment(UserCustomerImgDTO userCustomerImgDTO);
    void insertAsk(UserAskDTO ask);
    void insertImage(UserCustomerImgDTO fileInfo, int askCode);
}
