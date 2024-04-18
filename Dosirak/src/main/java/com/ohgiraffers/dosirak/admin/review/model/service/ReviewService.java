package com.ohgiraffers.dosirak.admin.review.model.service;

import com.ohgiraffers.dosirak.admin.review.model.dao.ReviewMapper;
import com.ohgiraffers.dosirak.admin.review.model.dto.ReviewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    public ReviewService(ReviewMapper reviewMapper) { this.reviewMapper = reviewMapper; }
    public List<ReviewDTO> allReview() {

        return reviewMapper.allReview();
    }

    public ReviewDTO selectReviewDetail(int reviewCode) {

        /* 게시글 상세 내용 조회 후 리턴 */
        return reviewMapper.searchReviewDetail(reviewCode);
    }
}
