package com.ohgiraffers.dosirak.admin.review;


import com.ohgiraffers.dosirak.admin.review.model.dto.AdminDTO;
import com.ohgiraffers.dosirak.admin.review.model.dto.AnswerDTO;
import com.ohgiraffers.dosirak.admin.review.model.dto.ReviewDTO;
import com.ohgiraffers.dosirak.admin.review.model.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/answerDetail")
    public String getAnswerDetail(@RequestParam("answerCode") int answerCode, Model model) {

        AnswerDTO answerDetail = reviewService.selectAnswerDetail(answerCode);

        model.addAttribute("answer", answerDetail);


        return "admin/review/reviewDetail";
    }

    @GetMapping("/reviewDetail")
    public String getNoticeDetail(@RequestParam("reviewCode") int reviewCode, Model model) {

        ReviewDTO reviewDetail = reviewService.selectReviewDetail(reviewCode);

        model.addAttribute("review", reviewDetail);


        return "admin/review/reviewDetail";
    }

    @PostMapping("registAnswer")
    public ResponseEntity<String> registAnswer(@RequestBody AnswerDTO registAnswer,
                                               @AuthenticationPrincipal AdminDTO adminId) {
        registAnswer.setAdminId(adminId);

        reviewService.registAnswer(registAnswer);

        return ResponseEntity.ok("댓글 등록 완료");
    }

//    @GetMapping("/reviewDetail")
//    public String getAskDetail(@RequestParam("reviewCode") int reviewCode, Model model) {
//
//        ReviewDTO reviewDetail = reviewService.selectReviewDetail(reviewCode);
////        AnswerDTO answerDetail = reviewService.selectAnswerDetail(reviewCode);
////        List<AskCategoryDTO> categoryList = customerService.findCategoryList();
//
//        model.addAttribute("review", reviewDetail);
////        model.addAttribute("answer", answerDetail);
////        model.addAttribute("askCategory", categoryList);
//
//        return "admin/review/reviewDetail";
//    }
}
