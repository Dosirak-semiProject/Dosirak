package com.ohgiraffers.dosirak.user.myInfo.model.dao;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyinfoMapper {
    MemberDTO myinfoSelect(String id);
}
