package com.ohgiraffers.dosirak.admin.member.contoller;

import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/memberList")
    public String findMemberList(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);

        return "/admin/member/memberList";
    }

    @GetMapping("/managerList")
    public String findManagerList(Model model){
        List<ManagerDTO> managerList = memberService.findAllManager();
        model.addAttribute("managerList", managerList);

        return "/admin/member/managerList";
    }

}
