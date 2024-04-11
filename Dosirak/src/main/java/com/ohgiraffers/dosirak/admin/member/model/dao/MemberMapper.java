package com.ohgiraffers.dosirak.admin.member.model.dao;

import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {

    List<MemberDTO> findAllMember();

    List<ManagerDTO> findAllManager();
}