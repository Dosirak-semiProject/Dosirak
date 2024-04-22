package com.ohgiraffers.dosirak.admin.customer.model.dao;

import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    /* ----- 공지사항 ----- */
    List<NoticeDTO> findNoticeList();
    NoticeDTO searchNoticeDetail(int noticeCode);
    void insertNotice(NoticeDTO notice);
    void deleteNotice(int noticeCode);
    void updateNotice(NoticeDTO noticeTemp);


    /* ----- 자주 묻는 질문 ----- */
    List<QnaDTO> findQnaList();
    QnaDTO searchQnaDetail(int qnaCode);
    void insertQna(QnaDTO qna);
    void deleteQna(int qnaCode);
    void updateQna(QnaDTO qnaTemp);


    /* ----- 1대1 문의 ----- */
    List<AskDTO> findAskList();
    AskDTO searchAskDetail(int askCode);
    AnswerDTO searchAnswerDetail(int askCode);
    List<AskCategoryDTO> findCategoryList();



}
