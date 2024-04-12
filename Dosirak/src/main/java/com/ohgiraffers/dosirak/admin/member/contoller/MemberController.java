package com.ohgiraffers.dosirak.admin.member.contoller;

import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
import com.ohgiraffers.dosirak.common.member.MemberModifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/memberList")
    public String findMemberList(Model model){
        List<MemberDTO> memberList = memberService.findAllMember();
        model.addAttribute("memberList", memberList);

        return "/admin/member/memberList";
    }
    @PostMapping("/memberList")
    public String memberListSearch(@RequestParam(required = false)String memberSearchCondition, @RequestParam(required = false)String memberSearchValue, Model model){
        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("memberSearchCondition", memberSearchCondition);
        searchMap.put("memberSearchValue", memberSearchValue);

        List<MemberDTO> memberList = memberService.memberListSearch(searchMap);
        model.addAttribute("memberList", memberList);

        return "/admin/member/memberList";
    }
    @GetMapping("/memberView")
    public String getMemberView(@RequestParam String id, Model model){
        MemberDTO member = memberService.selectMemberView(id);
        model.addAttribute("member", member);

        return "/admin/member/memberView";
    }
    @PostMapping("/modifyMember")
    public String modifyMember(MemberDTO member) throws MemberModifyException {
        if(member.getAgree() == "") member.setAgree(null);
        if(member.getAddress1() == "") member.setAddress1(null);
        if(member.getAddress2() == "") member.setAddress2(null);
        if(member.getAddress3() == "") member.setAddress3(null);

        memberService.modifyMember(member);

        return "redirect:/admin/member/memberList";
    }

    @GetMapping("/managerList")
    public String findManagerList(Model model){
        List<ManagerDTO> managerList = memberService.findAllManager();
        model.addAttribute("managerList", managerList);

        return "/admin/member/managerList";
    }
    @GetMapping("/managerView")
    public String getManagerView(@RequestParam String id, Model model){
        ManagerDTO manager = memberService.selectManagerView(id);
        model.addAttribute("manager", manager);

        return "/admin/member/managerView";
    }

    @PostMapping("/modifyManager")
    public String modifyManager(ManagerDTO manager) throws MemberModifyException {
        if(manager.getContact() == "") manager.setContact(null);

        memberService.modifyManager(manager);

        return "redirect:/admin/member/managerList";
    }




    @GetMapping("join")
    public void join(){}

    @PostMapping("idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody MemberDTO member){
        System.out.println(member.getEmail());
        String[] emailSplit = member.getEmail().split("@");
        member.setId(emailSplit[0]);

        String result = "사용 가능한 이메일입니다.";
        if(memberService.checkDuplication(member.getId())) result = "중복 이메일이 존재합니다.";

        return ResponseEntity.ok(result);
    }
}
