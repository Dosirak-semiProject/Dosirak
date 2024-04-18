package com.ohgiraffers.dosirak.admin.customer.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class AskDTO {

    private int askCode;
    private String askTitle;
    private String askContent;
    private LocalDateTime askDate;
    private String userId;
    private LocalDateTime editDate;
    private Boolean askDelete;
    private AskCategoryDTO askCategoryCode; //추후 수정
    private AnswerDTO answerDTO;

}
