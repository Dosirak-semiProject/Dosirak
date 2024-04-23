package com.ohgiraffers.dosirak.admin.customer.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class QnaDTO {

    private int qnaCode;
    private String qnaTitle;
    private String qnaAnswer;
    private String adminId;
    private AskCategoryDTO askCategoryCode;

    public QnaDTO() {};

    public QnaDTO(int askCategoryCode, String qnaTitle, String qnaAnswer, String adminID) {
    }
}
