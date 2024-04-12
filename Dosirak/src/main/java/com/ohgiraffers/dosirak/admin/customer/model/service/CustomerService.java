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


//    @Transactional
//    public List<NoticeDTO> searchPosts(String keyword) {
//
//        return customerMapper.searchPosts(keyword);
//    }

    public Map<String, Object> selectNoticeList(Map<String, String> searchMap, int page) {

        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위함 */
        int totalCount = customerMapper.selectTotalCount(searchMap);

        /* 2. 페이징 처리와 연관된 값을 계산하여 SelectCriteria 타입의 객체에 담기 */
        int limit = 10;         //한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   //한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);

        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
        List<NoticeDTO> noticeList = customerMapper.selectNoticeList(selectCriteria);

        Map<String, Object> noticeListAndPaging = new HashMap<>();
        noticeListAndPaging.put("paging", selectCriteria);
        noticeListAndPaging.put("noticeList", noticeList);

        return noticeListAndPaging;
    }
}
