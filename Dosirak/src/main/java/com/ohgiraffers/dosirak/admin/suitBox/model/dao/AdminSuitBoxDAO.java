package com.ohgiraffers.dosirak.admin.suitBox.model.dao;

import com.ohgiraffers.dosirak.admin.suitBox.model.dto.SuitBoxMenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminSuitBoxDAO {
    List<SuitBoxMenuDTO> getSuitBoxMenu();
}
