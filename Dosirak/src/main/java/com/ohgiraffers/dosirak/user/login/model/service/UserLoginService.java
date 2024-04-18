package com.ohgiraffers.dosirak.user.login.model.service;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.user.login.model.dao.UserLoginMapper;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class UserLoginService {

    @Autowired
    private UserLoginMapper userLoginMapper;

    public LoginDTO findById(String id){
        LoginDTO login = userLoginMapper.findById(id);

        if(!Objects.isNull(login)){
            return login;
        }else{
            return null;
        }
    }

    public MemberDTO findIDform(MemberDTO member) {
        return userLoginMapper.findIDform(member);
    }

    public MemberDTO findPWDform(MemberDTO member) {
        return userLoginMapper.findPWDform(member);
    }
}
