package com.ohgiraffers.dosirak.user.review.model.service;

import com.ohgiraffers.dosirak.user.review.model.dao.UserReviewMapper;
import com.ohgiraffers.dosirak.user.review.model.dto.UserReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewService {

    private final UserReviewMapper userReviewMapper;

    public UserReviewService(UserReviewMapper userReviewMapper) { this.userReviewMapper = userReviewMapper; }
    public List<UserReviewDTO> allUserReview() {

        return userReviewMapper.allUserReview();
    }

    public UserReviewDTO selectUserReviewDetail(int reviewCode) {

        return userReviewMapper.searchUserReviewDetail(reviewCode);
    }
}
