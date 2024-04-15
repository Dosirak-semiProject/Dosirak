package com.ohgiraffers.dosirak.admin.customer.model.service;

import com.ohgiraffers.dosirak.admin.customer.common.Pagenation;
import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dao.CustomerMapper;
import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class CustomerService {

    private final CustomerMapper customerMapper;

    public CustomerService(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }


    public List<NoticeDTO> findNoticeList() {

        return customerMapper.findNoticeList();
    }


    public NoticeDTO selectNoticeDetail(int noticeCode) {

        /* 게시글 상세 내용 조회 후 리턴 */
        return customerMapper.searchNoticeDetail(noticeCode);
    }
}
