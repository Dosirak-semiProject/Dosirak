package com.ohgiraffers.dosirak.admin.customer.model.dao;

import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AnswerDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AskCategoryDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AskDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
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


    /* ----- 1대1 문의 ----- */
    List<AskDTO> findAskList();
    AskDTO searchAskDetail(int askCode);
    AnswerDTO searchAnswerDetail(int askCode);
    List<AskCategoryDTO> findCategoryList();
}
