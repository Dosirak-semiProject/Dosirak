package com.ohgiraffers.dosirak.admin.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/join")
public class JoinController {
    @GetMapping("/join01")
    public void join01(){}
}
