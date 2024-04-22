package com.ohgiraffers.dosirak.admin.survey.model.service;

import com.ohgiraffers.dosirak.admin.survey.model.dao.SurveyAdminMapping;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyVersionDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class SurveyAdminService {
    private final SurveyAdminMapping surveyMapper;

    public SurveyAdminService(SurveyAdminMapping surveyMapper) {
        this.surveyMapper = surveyMapper;
    }

    public List<SurveyResultDTO> surveyList(){
        return surveyMapper.allList();
    }

    public SurveyVersionDTO getVersionByVersionId(int versionId) {
        return surveyMapper.getVersionByVersionId(versionId);
    }

    public List<SurveyVersionDTO> getAllVersion() {
        return surveyMapper.getAllVersion();
    }

    public List<SurveyQuestionDTO> getQuestionListByVersionId(int versionId) {
        return surveyMapper.getQuestionListByVersionId(versionId);
    }
}
