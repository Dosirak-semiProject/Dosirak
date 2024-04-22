package com.ohgiraffers.dosirak.user.customer.model.dao;

import com.ohgiraffers.dosirak.user.customer.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserCustomerMapper {


    /* ----- 공지사항 ----- */
    List<UserNoticeDTO> findNoticeList();
    UserNoticeDTO searchNoticeDetail(int noticeCode);


    /* ----- 자주 묻는 질문 ----- */
    List<UserQnaDTO> findQnaList();
    UserQnaDTO searchQnaDetail(int qnaCode);
    List<UserAskCategoryDTO> findCategoryList();


    /* ----- 1대1 문의 ----- */
    List<UserAskDTO> findAskList();
    UserAskDTO searchAskDetail(int askCode);
    void insertAttachment(UserCustomerImgDTO userCustomerImgDTO);
    void insertAsk(UserAskDTO ask);
    void insertImage(UserCustomerImgDTO fileInfo, int askCode);



}

