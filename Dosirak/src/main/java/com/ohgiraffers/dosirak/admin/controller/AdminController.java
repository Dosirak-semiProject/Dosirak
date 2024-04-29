package com.ohgiraffers.dosirak.admin.controller;

import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private MemberService memberService;

    @GetMapping("main")
    public ModelAndView main(ModelAndView mv, @RequestParam(required = false) String message){
        // 날짜별 회원가입자 수
        List<Map<String, String>> joinCount = memberService.joinCount();
        mv.addObject("joinCount", joinCount);

        // 오늘까지 총 회원수
        int joinNum = memberService.joinNum();
        mv.addObject("joinNum", joinNum);

        // 총 문의수
        int askNum = memberService.askNum();
        mv.addObject("askNum", askNum);

        // 총 수익

        mv.addObject("message", message);
        mv.setViewName("/admin/main");
        return mv;
    }
}
