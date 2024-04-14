package com.ohgiraffers.dosirak.user.join.controller;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.user.join.model.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user/join")
public class JoinCotroller {

    @Autowired
    private JoinService joinService;

    @GetMapping("/join01")
    public void join01(){}

    @GetMapping("/join02")
    public void join02(){}

    @GetMapping("/join03")
    public void join03(){}

    @PostMapping("/idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member){
        String result = "";
        if(member.getId() == null || member.getId() == ""){
            result = "아이디를 입력해주세요";
        }else{
            result = "사용 가능한 아이디입니다";
            if(joinService.checkDuplication(member.getId())) result = "중복 아이디가 존재합니다";
        }

        return ResponseEntity.ok(result);
    }

}
