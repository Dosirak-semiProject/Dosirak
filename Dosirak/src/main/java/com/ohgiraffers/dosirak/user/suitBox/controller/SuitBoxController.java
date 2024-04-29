package com.ohgiraffers.dosirak.user.suitBox.controller;

import com.ohgiraffers.dosirak.admin.login.model.AdminLoginDetails;
import com.ohgiraffers.dosirak.admin.suitBox.model.dto.SuitBoxMenuDTO;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import com.ohgiraffers.dosirak.user.suitBox.model.dao.SuitBoxMapper;
import com.ohgiraffers.dosirak.user.suitBox.model.dto.SuitBoxDTO;
import com.ohgiraffers.dosirak.user.suitBox.model.service.SuitBoxService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/suit-box")
public class SuitBoxController {
    private final SuitBoxService suitBoxService;

    public SuitBoxController(SuitBoxService suitBoxService) {
        this.suitBoxService = suitBoxService;
    }

    @GetMapping("")
    public String suitBox(Model model) {
        List<SuitBoxMenuDTO> saleMenuList = suitBoxService.selectSaleMenu();
        model.addAttribute("menuList", saleMenuList);
        return"user/suitBox/productView_suitBox";
    }
    @PostMapping("/cart")
    public @ResponseBody String cart(Model model, @ModelAttribute SuitBoxDTO suitBox) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = "";
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();

            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                String managerAuthor = ((LoginDTO) login).getAuthority();
                userId = login.getId();

                model.addAttribute("userId", userId);
            }
        }
        suitBox.setUserId(userId);
        Integer checkSuitBoxResult = suitBoxService.checkSuitBoxBySuitBox(suitBox);
        if(checkSuitBoxResult == null){
            suitBoxService.insertSuitBoxBySuitBox(suitBox);
        }
        int suitBoxCode = suitBoxService.checkSuitBoxCode(suitBox);
        suitBox.setSuitboxCode(suitBoxCode);
        System.out.println(suitBox.getSuitboxCode());
        Integer checkCartQuantity = suitBoxService.checkCartBySuitBox(suitBox);
        if(checkCartQuantity == null){
            suitBoxService.insertCartBySuitBox(suitBox);
        } else {
            suitBox.setQuantity(suitBox.getQuantity() + checkCartQuantity);
            suitBoxService.updateCartBySuitBox(suitBox);
        }
        return "test";
    }
}
