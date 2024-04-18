package com.ohgiraffers.dosirak.admin.review;


import com.ohgiraffers.dosirak.admin.review.model.dto.ReviewDTO;
import com.ohgiraffers.dosirak.admin.review.model.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("reviewList")
    public String allReviewList(Model model){


        List<ReviewDTO> reviewDTOList = reviewService.allReview();
        for(ReviewDTO r : reviewDTOList){
            System.out.println(r);
        }


        model.addAttribute("reviewList", reviewDTOList);

        return "admin/review/reviewList";
    }

    @GetMapping("/reviewDetail")
    public String getNoticeDetail(@RequestParam("reviewCode") int reviewCode, Model model) {

        ReviewDTO reviewDetail = reviewService.selectReviewDetail(reviewCode);

        model.addAttribute("review", reviewDetail);

        return "admin/review/reviewDetail";
    }
}
