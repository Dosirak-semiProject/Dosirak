package com.ohgiraffers.dosirak.user.customer.model.dto;

import com.ohgiraffers.dosirak.admin.customer.model.dto.AnswerDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class UserAskDTO {

    private int askCode;
    private String askTitle;
    private String askContent;
    private LocalDateTime askDate;
    private String userId;
    private LocalDateTime editDate;
    private Boolean askDelete;
    private UserAskCategoryDTO askCategoryCode; //추후 수정
    private AnswerDTO answerDTO;

    private List<UserCustomerImgDTO> imageList;

}
