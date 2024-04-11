package com.ohgiraffers.dosirak.admin.member.contoller;

import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
import com.ohgiraffers.dosirak.common.member.MemberModifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/memberView")
    public String getMemberView(@RequestParam String id, Model model){
        MemberDTO member = memberService.selectMemberView(id);
        model.addAttribute("member", member);

        return "/admin/member/memberView";
    }

    @PostMapping("/modify")
    public String modifyMember(MemberDTO member, RedirectAttributes rttr) throws MemberModifyException {
        memberService.modifyMember(member);

        return "redirect:/admin/member/memberList";
    }
//    @PostMapping("/update")
//    public String modifyMember(MemberDTO modifyMember, String zipCode, String address1, String address2,
//                               @AuthenticationPrincipal MemberDTO loginMember, RedirectAttributes rttr) throws MemberModifyException {
//
//        String address = zipCode + "$" + address1 + "$" + address2;
//        modifyMember.setAddress(address);
//        modifyMember.setMemberNo(loginMember.getMemberNo());
//
//        log.info("modifyMember request Member : {}", modifyMember);
//
//        memberService.modifyMember(modifyMember);
//
//        /* 로그인 시 저장 된 Authentication 객체를 변경 된 정보로 교체한다. */
//        SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(loginMember.getMemberId()));
//
//        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));
//
//        return "redirect:/";
//    }


}
