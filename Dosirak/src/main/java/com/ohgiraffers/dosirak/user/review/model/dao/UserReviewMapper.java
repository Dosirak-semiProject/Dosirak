package com.ohgiraffers.dosirak.user.review.model.dao;

import com.ohgiraffers.dosirak.admin.review.model.dto.ReviewDTO;
import com.ohgiraffers.dosirak.user.review.model.dto.UserReviewDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserReviewMapper {
    List<UserReviewDTO> allUserReview();

    UserReviewDTO searchUserReviewDetail(int reviewCode);
}
