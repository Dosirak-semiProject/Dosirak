package com.ohgiraffers.dosirak.admin.controller;

import com.ohgiraffers.dosirak.admin.controller.model.service.AdminMainService;
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
    private AdminMainService adminMainService;

    @GetMapping("main")
    public ModelAndView main(ModelAndView mv, @RequestParam(required = false) String message){
        // 날짜별 회원가입자 수
        List<Map<String, String>> joinCount = adminMainService.joinCount();
        mv.addObject("joinCount", joinCount);

        // 오늘까지 총 회원수
        int joinNum = adminMainService.joinNum();
        mv.addObject("joinNum", joinNum);

        mv.addObject("message", message);
        mv.setViewName("/admin/main");
        return mv;
    }
}
