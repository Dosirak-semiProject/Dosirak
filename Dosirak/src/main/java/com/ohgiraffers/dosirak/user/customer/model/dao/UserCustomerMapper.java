package com.ohgiraffers.dosirak.user.customer.model.dao;

import com.ohgiraffers.dosirak.user.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.user.customer.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

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
    UserAnswerDTO searchAnswerDetail(int askCode);
    void insertAttachment(UserCustomerImgDTO userCustomerImgDTO);
    void insertAsk(UserAskDTO ask);
    void insertImage(UserCustomerImgDTO fileInfo);

    /* -- 추가 --- */
    int selectTotalCount(Map<String, String> searchMap);
    List<UserAskDTO> selectAskList(SelectCriteria selectCriteria);
}

