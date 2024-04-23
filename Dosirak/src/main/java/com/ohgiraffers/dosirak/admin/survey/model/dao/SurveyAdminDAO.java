package com.ohgiraffers.dosirak.admin.survey.model.dao;

import com.ohgiraffers.dosirak.admin.survey.model.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SurveyAdminDAO {

    List<SurveyResultDTO> allList();

    SurveyVersionDTO getVersionByVersionId(int versionId);

    List<SurveyVersionDTO> getAllVersion();

    List<SurveyQuestionDTO> getQuestionListByVersionId(int versionId);

    List<SurveyCategoryRangeDTO> getRangeListByVersionId(int versionId);

    int deleteVersionByVersionId(int versionId);

    void deleteQuestionByVersionId(int versionId);

    void getDeleteAnswerByVersionId(int versionId);

    void deleteRangeByVersionId(int versionId);
}
