package com.ohgiraffers.dosirak.user.myInfo.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.user.myInfo.model.dao.MyinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyinfoService {

    @Autowired
    private MyinfoMapper myinfoMapper;

    public MemberDTO myinfoSelect(String id) {
        return myinfoMapper.myinfoSelect(id);
    }
}
