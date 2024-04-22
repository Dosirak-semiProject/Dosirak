package com.ohgiraffers.dosirak.admin.survey.model.dao;

import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyVersionDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyAdminMapping {

    List<SurveyResultDTO> allList();

    SurveyVersionDTO getVersionByVersionId(int versionId);

    List<SurveyVersionDTO> getAllVersion();

    List<SurveyQuestionDTO> getQuestionListByVersionId(int versionId);
}
