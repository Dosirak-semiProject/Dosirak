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

//    @GetMapping("/noticeList")
//    public String noticeList(Model model) {
//
//        List<NoticeDTO> noticeList = customerService.findNoticeList();
//
//        model.addAttribute("noticeList", noticeList);
//
//        return "admin/customer/noticeList";
//    }


//    @GetMapping("/noticeList")
//    public String noticeList(@RequestParam(defaultValue = "1") int page,
//                             @RequestParam(required = false) String searchValue,
//                             Model model) {
//
//        Map<String, Object> noticeListAndPaging = customerService.selectNoticeList(searchValue, page);
//        model.addAttribute("paging", noticeListAndPaging.get("paging"));
//        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));
//
//
//        return "admin/customer/noticeList";
//    }

    @GetMapping("/noticeList")
    public String noticeList(@RequestParam(defaultValue = "1") int page,
                            @RequestParam(required = false) String searchCondition,
                            @RequestParam(required = false) String searchValue,
                            Model model) {

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> noticeListAndPaging = customerService.selectNoticeList(searchMap, page);
        model.addAttribute("paging", noticeListAndPaging.get("paging"));
        model.addAttribute("noticeList", noticeListAndPaging.get("noticeList"));


        return "admin/customer/noticeList";
    }

//    @GetMapping("/searchNoticeList")
//    public String search(@RequestParam(value = "keyword") String keyword,
//                         Model model) {
//
//        List<NoticeDTO> noticeList = customerService.searchPosts(keyword);
//        model.addAttribute("noticeList", noticeList);
//
//        return "admin/customer/searchNoticeList";
//    }


}
