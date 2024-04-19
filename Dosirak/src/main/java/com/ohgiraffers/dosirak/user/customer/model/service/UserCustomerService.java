package com.ohgiraffers.dosirak.user.customer.model.service;


import com.ohgiraffers.dosirak.admin.customer.model.dto.AskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dao.UserCustomerMapper;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserAskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserCustomerImgDTO;
import org.springframework.stereotype.Service;

@Service
public class UserCustomerService {

    private final UserCustomerMapper userCustomerMapper;

    public UserCustomerService(UserCustomerMapper userCustomerMapper) {
        this.userCustomerMapper = userCustomerMapper;
    }

    /* 1대1 문의페이지 */

    public void registThumnail(AskDTO ask) {

        /* UserCustomerImag 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        ask.getImageList().forEach(UserCustomerImgDTO -> {
            UserCustomerImgDTO.setRefAskCode(ask.getAskCode());
            userCustomerMapper.insertAttachment(UserCustomerImgDTO);
        });

    }

    public void askRegist(UserAskDTO ask) {

        userCustomerMapper.insertAsk(ask);
    }

    public void registImage(UserCustomerImgDTO fileInfo, int askCode) {

        userCustomerMapper.insertImage(fileInfo, askCode);
    }
}
