package com.ohgiraffers.dosirak.user.review;

import com.ohgiraffers.dosirak.user.review.model.dto.UserReviewDTO;
import com.ohgiraffers.dosirak.user.review.model.service.UserReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/user/review")
public class UserReviewController {

    private final UserReviewService userReviewService;

    public UserReviewController(UserReviewService userReviewService) { this.userReviewService = userReviewService; }


    @GetMapping("/list")
    public String allUserReviewList(Model model){

        List<UserReviewDTO> userReviewDTOList = userReviewService.allUserReview();
        for(UserReviewDTO r : userReviewDTOList){
            System.out.println(r);
        }

        model.addAttribute("userReviewList", userReviewDTOList);

        return "user/review/list";
    }

    @GetMapping("/userReview")
    public String getUserReviewDetail(@RequestParam("reviewCode") int reviewCode, Model model) {

        UserReviewDTO userReviewDetail = userReviewService.selectUserReviewDetail(reviewCode);

        model.addAttribute("review", userReviewDetail);

        return "user/review/userReview";
    }
}
