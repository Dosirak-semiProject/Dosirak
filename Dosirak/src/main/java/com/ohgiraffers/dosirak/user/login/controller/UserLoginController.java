package com.ohgiraffers.dosirak.user.login.controller;

import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/login")
public class UserLoginController {

    @GetMapping("/findID")
    public void findID(){}

    @GetMapping("/findPWD")
    public void findPWD(){}
}
