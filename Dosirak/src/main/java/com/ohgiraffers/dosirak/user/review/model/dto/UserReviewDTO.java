package com.ohgiraffers.dosirak.user.review.model.dto;

import com.ohgiraffers.dosirak.admin.review.model.dto.AdminDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserReviewDTO {
    private int reviewCode;
    private String reviewContent;
    private String reviewRecommend;
    private String userId;
//    private LocalDateTime reviewEditDate; // 추후 수정
    private String reviewDelete;
    private int detailCode;
    private LocalDateTime reviewDate;
    private AdminDTO adminId;
}
