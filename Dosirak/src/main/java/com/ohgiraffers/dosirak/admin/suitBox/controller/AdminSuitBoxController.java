package com.ohgiraffers.dosirak.admin.suitBox.controller;

import com.ohgiraffers.dosirak.admin.suitBox.model.dto.SuitBoxMenuDTO;
import com.ohgiraffers.dosirak.admin.suitBox.model.service.AdminSuitBoxService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/suit-box/menu")
public class AdminSuitBoxController {
    private final AdminSuitBoxService service;
    public AdminSuitBoxController(AdminSuitBoxService service) {
        this.service = service;
    }
    @GetMapping("/view")
    public String view(String searchValue,String category, Model model) {

        List<SuitBoxMenuDTO> menuList = service.getSuitBoxMenu();
        model.addAttribute("menuList", menuList);
        return "admin/suitBox/suitBoxMenuView";
    }
    @GetMapping("/set")
    public String set(String searchValue,String category, Model model) {
        model.addAttribute("setCondition", "regist");
        return "admin/suitBox/suitBoxMenuSet";
    }
    @PostMapping("/set-menu")
    public String setMenu(SuitBoxMenuDTO menu, Model model) {
        String result = "";
        int resultInt = service.registMenu(menu);
        if(resultInt == 1) {
            result = "redirect:/admin/suit-box/menu/view";
        }
        return result;
    }
}
