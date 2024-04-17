package com.ohgiraffers.dosirak.admin.customer.controller;

import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import com.ohgiraffers.dosirak.admin.customer.model.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/noticeList")
    public String noticeList(Model model) {

        List<NoticeDTO> noticeList = customerService.findNoticeList();

        model.addAttribute("noticeList", noticeList);

        return "admin/customer/noticeList";
    }

    @GetMapping("/noticeDetail")
    public String getNoticeDetail(@RequestParam("noticeCode") int noticeCode, Model model) {

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

}
