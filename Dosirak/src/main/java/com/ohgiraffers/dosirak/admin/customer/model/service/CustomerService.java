package com.ohgiraffers.dosirak.admin.customer.model.service;

import com.ohgiraffers.dosirak.admin.customer.common.Pagenation;
import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dao.CustomerMapper;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AnswerDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AskCategoryDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AskDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import java.util.*;

@Slf4j
@Service
public class CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }


    /* ----- 공지사항 ----- */
    public List<NoticeDTO> findNoticeList() {

        return customerMapper.findNoticeList();
    }

    public NoticeDTO selectNoticeDetail(int noticeCode) {

        /* 게시글 상세 내용 조회 후 리턴 */
        return customerMapper.searchNoticeDetail(noticeCode);
    }

    public void writeNotice(NoticeDTO notice) {

        customerMapper.insertNotice(notice);
    }

    public void deleteNotice(int noticeCode) {

        customerMapper.deleteNotice(noticeCode);
    }

    public void updateNotice(NoticeDTO noticeTemp) {

        customerMapper.updateNotice(noticeTemp);
    }

    /* ----- 1대1 문의 ----- */
    public List<AskDTO> findAskList() {

        // 1대1 문의내역 반환
        return customerMapper.findAskList();
    }

    public AskDTO selectAskDetail(int askCode) {

        /* 상담내역 상세 내용 조회 후 리턴 */
        return customerMapper.searchAskDetail(askCode);
    }

    public AnswerDTO selectAnswerDetail(int askCode) {

        /* 답변내역 상세 내용 조회 후 리턴 */
        return customerMapper.searchAnswerDetail(askCode);
    }

    public List<AskCategoryDTO> findCategoryList() {

        return customerMapper.findCategoryList();
    }
}