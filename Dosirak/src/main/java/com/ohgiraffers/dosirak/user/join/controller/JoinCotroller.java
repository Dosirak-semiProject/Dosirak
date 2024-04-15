package com.ohgiraffers.dosirak.user.join.controller;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.common.member.MemberRegistException;
import com.ohgiraffers.dosirak.user.join.model.service.JoinService;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user/join")
public class JoinCotroller {

    private final JoinService joinService;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceAccessor messageSourceAccessor;

    public JoinCotroller(JoinService joinService, PasswordEncoder passwordEncoder, MessageSourceAccessor messageSourceAccessor){
        this.joinService = joinService;
        this.passwordEncoder = passwordEncoder;
        this.messageSourceAccessor = messageSourceAccessor;
    }

    @GetMapping("/join01")
    public void join01(){}

    @GetMapping("/join02")
    public void join02(){}

    @GetMapping("/joinDone")
    public void joinDone(){}

    @PostMapping("/idCheck")
    @ResponseBody
    public boolean idCheck(@RequestParam("id") String id){
        boolean result = joinService.idCheck(id);
        return result;
    }

    @PostMapping("joinForm")
    public String joinForm(MemberDTO member, RedirectAttributes rttr) throws MemberRegistException {
        member.setPwd(passwordEncoder.encode(member.getPwd()));
        joinService.registMember(member);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.regist"));

        return "redirect:/user/join/joinDone";
    }

}
