package com.ohgiraffers.dosirak.admin.survey.model.service;

import com.ohgiraffers.dosirak.admin.survey.model.dao.SurveyAdminMapping;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
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

}
