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
//    private LocalDateTime editDate; //추후 수정
    private Boolean askDelete;
    private int askCategoryCode; //추후 수정

    public AskDTO() {}

}
