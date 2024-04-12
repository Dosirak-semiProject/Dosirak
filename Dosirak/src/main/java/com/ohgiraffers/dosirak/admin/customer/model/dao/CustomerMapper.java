package com.ohgiraffers.dosirak.admin.customer.model.dao;

import com.ohgiraffers.dosirak.admin.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerMapper {

    List<NoticeDTO> findNoticeList();

    int selectTotalCount(Map<String, String> searchMap);

    List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

    List<NoticeDTO> searchPosts(String keyword);

}
