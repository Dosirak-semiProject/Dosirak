package com.ohgiraffers.dosirak.admin.survey.model.dao;

import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyAdminMapping {

    List<SurveyResultDTO> allList();
}
