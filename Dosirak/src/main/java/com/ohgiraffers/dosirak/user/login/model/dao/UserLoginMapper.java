package com.ohgiraffers.dosirak.user.login.model.dao;

import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserLoginMapper {

    LoginDTO findById(String id);
}
