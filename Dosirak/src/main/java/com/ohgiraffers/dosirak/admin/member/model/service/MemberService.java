package com.ohgiraffers.dosirak.admin.member.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dao.MemberMapper;
import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<MemberDTO> findAllMember(){
        return memberMapper.findAllMember();
    }

    public List<ManagerDTO> findAllManager() {
        return memberMapper.findAllManager();
    }
}
