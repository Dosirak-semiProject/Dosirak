package com.ohgiraffers.dosirak.admin.customer.controller;

import com.ohgiraffers.dosirak.admin.customer.model.dto.*;
import com.ohgiraffers.dosirak.admin.customer.model.service.CustomerService;
import com.ohgiraffers.dosirak.admin.member.model.dto.ManagerDTO;
import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /* ----- 공지사항 관리페이지 ----- */

    @GetMapping("/noticeList")
    @PreAuthorize("hasRole('ADMIN')") // ADMIN 역할만 접근 가능
    public String noticeList(Model model) {

        List<NoticeDTO> noticeList = customerService.findNoticeList();

        model.addAttribute("noticeList", noticeList);

        return "admin/customer/noticeList";
    }

    @GetMapping("/noticeDetail")
    public String getNoticeDetail(@RequestParam("noticeCode") int noticeCode,
                                  Model model) {

        NoticeDTO noticeDetail = customerService.selectNoticeDetail(noticeCode);

        model.addAttribute("notice", noticeDetail);

        return "admin/customer/noticeDetail";
    }
    // parameter 인식 오류, 어노테이션 옆에 파라미터 값의 이름을 정확히 입력해주어 해결

    @GetMapping("/noticeWrite")
    public String noticeWrite() {

        return "admin/customer/noticeWrite";
    }

    @PostMapping("/noticeWrite")
    public String noticeWritePro(NoticeDTO notice) {

        customerService.writeNotice(notice);

        return "redirect:noticeList";
    }

    @RequestMapping("/noticeDelete")
    public String noticeDelete(NoticeDTO notice) {

        customerService.deleteNotice(notice.getNoticeCode());

        return "redirect:noticeList";
    }


    @GetMapping("/noticeEdit/{noticeCode}")
    public String noticeEdit(@PathVariable("noticeCode") int noticeCode, Model model) {

        model.addAttribute("notice", customerService.selectNoticeDetail(noticeCode));

        return "admin/customer/noticeEdit";
    }

    @PostMapping("/noticeUpdate/{noticeCode}")
    public String noticeUpdate(@PathVariable("noticeCode") int noticeCode, NoticeDTO notice) {

        //noticeTemp에 현재 공지사항 정보 담아 반환
        NoticeDTO noticeTemp = customerService.selectNoticeDetail(noticeCode);

        // 덮어쓰기
        noticeTemp.setNoticeTitle(notice.getNoticeTitle());
        noticeTemp.setNoticeContent(notice.getNoticeContent());

        // 업데이트
        customerService.updateNotice(noticeTemp);

        return "redirect:/admin/customer/noticeList";
    }

    /* ----- 자주 묻는 질문 관리페이지 ----- */

    @GetMapping("/qnaList")
    public String getQnaList(Model model) {

        List<QnaDTO> qnaList = customerService.findQnaList();

        model.addAttribute("qnaList", qnaList);

        return "admin/customer/qnaList";
    }

    @GetMapping("/qnaDetail")
    public String getQnaDetail(@RequestParam("qnaCode") int qnaCode, Model model) {

        QnaDTO qnaDetail = customerService.selectQnaDetail(qnaCode);

        model.addAttribute("qna", qnaDetail);

        return "admin/customer/qnaDetail";
    }

    @GetMapping("/qnaWrite")
    public String qnaWrite(Model model) {

        List<AskCategoryDTO> categoryList = customerService.findCategoryList();
        model.addAttribute("askCategory", categoryList);

        return "admin/customer/qnaWrite";
    }

    @PostMapping("/qnaWrite")
    public String qnaWritePro(@RequestParam("askCategoryCode") int askCategoryCode,
                              String qnaTitle, String qnaAnswer, String adminID) {

        // AskCategoryDTO 객체 생성 및 askCategoryCode 설정
        AskCategoryDTO askCategory = new AskCategoryDTO();
        askCategory.setAskCategoryCode(askCategoryCode);

        // QnaDTO 객체 생성 및 필드 설정
        QnaDTO newQna = new QnaDTO();
        newQna.setAskCategoryCode(askCategory);
        newQna.setQnaTitle(qnaTitle);
        newQna.setQnaAnswer(qnaAnswer);
        newQna.setAdminId(adminID);

        // 서비스로 전달
        customerService.writeQna(newQna);

        return "redirect:qnaList";
    }

    @RequestMapping("/qnaDelete")
    public String qnaDelete(QnaDTO qna) {

        customerService.deleteQna(qna.getQnaCode());

        return "redirect:qnaList";
    }

    /* 분류 수정되지 않는 점 수정 예정 */
    @GetMapping("/qnaEdit/{qnaCode}")
    public String qnaEdit(@PathVariable("qnaCode") int qnaCode, Model model) {

        List<AskCategoryDTO> categoryList = customerService.findCategoryList();

        model.addAttribute("qna", customerService.selectQnaDetail(qnaCode));
        model.addAttribute("askCategory", categoryList);

        return "admin/customer/qnaEdit";
    }

    @PostMapping("/qnaUpdate/{qnaCode}")
    public String qnaUpdate(@PathVariable("qnaCode") int qnaCode, QnaDTO qna) {

        //noticeTemp에 현재 공지사항 정보 담아 반환
        QnaDTO qnaTemp = customerService.selectQnaDetail(qnaCode);

        // 덮어쓰기
        qnaTemp.setQnaTitle(qna.getQnaTitle());
        qnaTemp.setQnaAnswer(qna.getQnaAnswer());

        // 업데이트
        customerService.updateQna(qnaTemp);

        return "redirect:/admin/customer/qnaList";
    }


    /* ----- 1대1 관리페이지 ----- */

    @GetMapping("/askList")
    public String askList(Model model) {

        List<AskDTO> askList = customerService.findAskList();

        model.addAttribute("askList", askList);

        return "/admin/customer/askList";
    }

    @GetMapping("/askDetail")
    public String getAskDetail(@RequestParam("askCode") int askCode, Model model) {

        AskDTO askDetail = customerService.selectAskDetail(askCode);
        AnswerDTO answerDetail = customerService.selectAnswerDetail(askCode);
        List<AskCategoryDTO> categoryList = customerService.findCategoryList();

        model.addAttribute("ask", askDetail);
        model.addAttribute("answer", answerDetail);
        model.addAttribute("askCategory", categoryList);

        return "admin/customer/askDetail";
    }

}
