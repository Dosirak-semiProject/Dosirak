package com.ohgiraffers.dosirak.admin.survey.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SurveyCategoryRangeDTO {
    private int versionId;
    private char category;
    private int range1;
    private int range2;
    private int range3;
    private int range4;
}
