package com.ohgiraffers.dosirak.admin.review.model.dao;

import com.ohgiraffers.dosirak.admin.review.model.dto.AnswerDTO;
import com.ohgiraffers.dosirak.admin.review.model.dto.ReviewDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<ReviewDTO> allReview();

    ReviewDTO searchReviewDetail(int reviewCode);

    void insertAnswer(AnswerDTO registAnswer);

    AnswerDTO searchAnswerDetail(int answerCode);
}
