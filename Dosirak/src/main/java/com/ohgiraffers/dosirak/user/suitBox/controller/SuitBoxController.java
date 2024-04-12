package com.ohgiraffers.dosirak.user.suitBox.controller;

import com.ohgiraffers.dosirak.user.suitBox.model.dao.SuitBoxMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class SuitBoxController {
    private final SuitBoxMapper suitBoxMapper;
    public SuitBoxController(SuitBoxMapper suitBoxMapper) {
        this.suitBoxMapper = suitBoxMapper;
    }

    @GetMapping("suit-box")
    public String suitBox(Model model) {
        return"user/suitBox/productView_suitBox";
    }
}
