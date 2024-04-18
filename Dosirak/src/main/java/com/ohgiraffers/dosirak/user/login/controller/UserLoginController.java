package com.ohgiraffers.dosirak.user.login.controller;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.user.login.model.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/login")
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @GetMapping("/findID")
    public void findID(){}

    @PostMapping("/findIDdone")
    public String findIDdone(MemberDTO member, Model model){
        MemberDTO findIdMem = userLoginService.findIDform(member);
        model.addAttribute("findIdMem", findIdMem);

        return "/user/login/findIDdone";
    }

    @GetMapping("/findPWD")
    public void findPWD(){}

    @PostMapping("/findPWDreset")
    public String findPWDreset(MemberDTO member, Model model){
        MemberDTO findPWDMem = userLoginService.findPWDform(member);
        model.addAttribute("findPWDMem", findPWDMem);

        return "/user/login/findPWDreset";
    }

    @PostMapping("/findPWDdone")
    public String findPWDdone(MemberDTO member, Model model){


        return "/user/login/findPWDdone";
    }
}
