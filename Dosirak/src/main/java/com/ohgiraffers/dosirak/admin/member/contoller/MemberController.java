package com.ohgiraffers.dosirak.admin.member.contoller;

import com.ohgiraffers.dosirak.admin.login.model.AdminLoginDetails;
import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.member.model.service.MemberService;
import com.ohgiraffers.dosirak.common.member.MemberModifyException;
import com.ohgiraffers.dosirak.common.member.MemberRegistException;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/admin/member")
public class MemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MessageSourceAccessor messageSourceAccessor;

    public MemberController(MemberService memberService, PasswordEncoder passwordEncoder, MessageSourceAccessor messageSourceAccessor){
        this.memberService = memberService;
        this.passwordEncoder = passwordEncoder;
        this.messageSourceAccessor = messageSourceAccessor;
    }

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();

            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                String managerAuthor = login.getAuthority();
                System.out.println("관리자 권한 등급 : " + managerAuthor);

                model.addAttribute("managerAuthor", managerAuthor);
            }
        }

        MemberDTO member = memberService.selectMemberView(id);
        model.addAttribute("member", member);

        return "/admin/member/memberView";
    }
    @PostMapping("/modifyMember")
    public String modifyMember(MemberDTO member, RedirectAttributes rttr) throws MemberModifyException {
        if(member.getAgree() == "") member.setAgree(null);
        if(member.getAddress1() == "") member.setAddress1(null);
        if(member.getAddress2() == "") member.setAddress2(null);
        if(member.getAddress3() == "") member.setAddress3(null);

        memberService.modifyMember(member);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.modify"));

        return "redirect:/admin/member/memberView?id="+member.getId();
    }
    @GetMapping("/memberPwdReset")
    public String memberPwdReset(@RequestParam String id, MemberDTO member, RedirectAttributes rttr) throws MemberModifyException {
        member.setPwd(passwordEncoder.encode(id));
        memberService.memberPwdReset(member);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("member.pwdReset"));

        return "redirect:/admin/member/memberView?id="+member.getId();
    }

    @GetMapping("/managerList")
    public String findManagerList(Model model){
        List<ManagerDTO> managerList = memberService.findAllManager();
        model.addAttribute("managerList", managerList);

        return "/admin/member/managerList";
    }
    @GetMapping("/managerView")
    public String getManagerView(@RequestParam String id, Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();

            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                String managerAuthor = login.getAuthority();
                System.out.println("관리자 권한 등급 : " + managerAuthor);

                model.addAttribute("managerAuthor", managerAuthor);
            }
        }

        ManagerDTO manager = memberService.selectManagerView(id);
        model.addAttribute("manager", manager);

        return "/admin/member/managerView";
    }
    @PostMapping("/modifyManager")
    public String modifyManager(ManagerDTO manager, RedirectAttributes rttr) throws MemberModifyException {
        if(manager.getContact() == "") manager.setContact(null);

        memberService.modifyManager(manager);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("manager.modify"));

        return "redirect:/admin/member/managerView?id="+manager.getId();
    }
    @GetMapping("/managerPwdReset")
    public String managerPwdReset(@RequestParam String id, ManagerDTO manager, RedirectAttributes rttr) throws MemberModifyException {
        manager.setPwd(passwordEncoder.encode(id));
        memberService.managerPwdReset(manager);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("manager.pwdReset"));

        return "redirect:/admin/member/managerView?id="+manager.getId();
    }

    @GetMapping("join")
    public void join(){}

    @PostMapping("idDupCheck")
    public ResponseEntity<String> checkDuplication(@RequestBody ManagerDTO manager){
        String result = "";
        if(manager.getEmail() == null || manager.getEmail() == ""){
            result = "이메일을 입력해주세요";
        }else{
            String[] emailSplit = manager.getEmail().split("@");
            manager.setId(emailSplit[0]);

            result = "사용 가능한 이메일입니다.";
            if(memberService.checkDuplication(manager.getId())) result = "중복 이메일이 존재합니다.";
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping("regist")
    public String registManager(ManagerDTO manager, RedirectAttributes rttr) throws MemberRegistException {
        String[] emailSplit = manager.getEmail().split("@");
        manager.setId(emailSplit[0]);
        manager.setPwd(passwordEncoder.encode(manager.getPwd()));
        memberService.registManager(manager);
        rttr.addFlashAttribute("message", messageSourceAccessor.getMessage("manager.regist"));

        return "redirect:/";
    }

}
