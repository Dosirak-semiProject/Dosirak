package com.ohgiraffers.dosirak.user.myInfo.controller;

import com.ohgiraffers.dosirak.admin.login.model.AdminLoginDetails;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.user.myInfo.model.service.MyinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/myinfo")
public class MyinfoController {

    @Autowired
    private MyinfoService myinfoService;

    @GetMapping("default")
    public String myinfo(@AuthenticationPrincipal AdminLoginDetails details, Model model){
        String id = details.getLoginDTO().getId();
        MemberDTO member = myinfoService.myinfoSelect(id);
        model.addAttribute("member", member);

        return "user/myinfo/default";
    }

//    @GetMapping("/memberView")
//    public String getMemberView(@RequestParam String id, Model model){
//        MemberDTO member = memberService.selectMemberView(id);
//        model.addAttribute("member", member);
//
//        return "/admin/member/memberView";
//    }

    @GetMapping("pwdCheck")
    public void pwdCheck(){}

    @GetMapping("withdrawal")
    public void withdrawal(){}

    @GetMapping("withdrawalDone")
    public void withdrawalDone(){}


//    @GetMapping("/update")
//    public void modifyPage(@AuthenticationPrincipal MemberDTO member, Model model) {
//
//        String[] address = member.getAddress().split("\\$");
//        model.addAttribute("address", address);
//
//    }
//@PostMapping("/update")
//public String modifyMember(MemberDTO modifyMember, String zipCode, String address1, String address2,
//                           @AuthenticationPrincipal MemberDTO loginMember, RedirectAttributes rttr) throws MemberModifyException {
//
//    String address = zipCode + "$" + address1 + "$" + address2;
//    modifyMember.setAddress(address);
//    modifyMember.setMemberNo(loginMember.getMemberNo());
//
//    log.info("modifyMember request Member : {}", modifyMember);
//
//    memberService.modifyMember(modifyMember);
//
//    /* 로그인 시 저장 된 Authentication 객체를 변경 된 정보로 교체한다. */
//    SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginMember.getMemberId()));
//
//    rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));
//
//    return "redirect:/";
//}
}
