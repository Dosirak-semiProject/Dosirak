package com.ohgiraffers.dosirak.admin.customer.model.dao;

import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    List<NoticeDTO> findNoticeList();

    NoticeDTO searchNoticeDetail(int noticeCode);

    void insertNotice(NoticeDTO notice);

    void deleteNotice(int noticeCode);

    void updateNotice(int noticeCode, NoticeDTO noticeTemp);
}
