package com.ohgiraffers.dosirak.admin.controller.model.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminMainMapper {
    List<Map<String, String>> joinCount();

    int joinNum();
}
