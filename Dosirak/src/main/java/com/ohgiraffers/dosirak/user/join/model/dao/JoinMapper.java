package com.ohgiraffers.dosirak.user.join.model.dao;

import com.ohgiraffers.dosirak.user.join.model.dto.JoinDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JoinMapper {

    int regist(JoinDTO joinDTO);

    String checkDuplication(String id);
}
