package com.ohgiraffers.dosirak.user.join.model.service;

import com.ohgiraffers.dosirak.user.join.model.dao.JoinMapper;
import com.ohgiraffers.dosirak.user.join.model.dto.JoinDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JoinService {

    private final JoinMapper joinMapper;
    private final PasswordEncoder passwordEncoder;

    public JoinService(JoinMapper joinMapper, PasswordEncoder passwordEncoder){
        this.joinMapper = joinMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public int regist(JoinDTO joinDTO){
        joinDTO.setUserPwd(passwordEncoder.encode(joinDTO.getUserPwd()));

        int result = 0;
        try {
            result = joinMapper.regist(joinDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  result;
    }

}
