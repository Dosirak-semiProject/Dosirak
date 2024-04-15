package com.ohgiraffers.dosirak.admin.customer.controller;

import com.ohgiraffers.dosirak.admin.customer.model.dto.NoticeDTO;
import com.ohgiraffers.dosirak.admin.customer.model.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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


}
