package com.ohgiraffers.dosirak.user.myInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/myinfo")
public class MyinfoController {

    @GetMapping("default")
    public String myinfo(){
        return "/user/myinfo/default";
    }

    @GetMapping("pwdCheck")
    public void pwdCheck(){}

    @GetMapping("withdrawal")
    public void withdrawal(){}

    @GetMapping("withdrawalDone")
    public void withdrawalDone(){}
}
