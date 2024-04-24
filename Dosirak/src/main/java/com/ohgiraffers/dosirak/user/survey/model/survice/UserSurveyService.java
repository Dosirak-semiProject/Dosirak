package com.ohgiraffers.dosirak.user.survey.model.survice;

import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyScoreRangeDTO;
import com.ohgiraffers.dosirak.user.survey.model.dao.UserSurveyDAO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserSurveyService {
    final private UserSurveyDAO mapper;
    public UserSurveyService(UserSurveyDAO mapper) {
        this.mapper = mapper;
    }


    public List<SurveyQuestionDTO> getCurrentSurvey() {
        return mapper.getCurrentSurvey();
    }


    public void setScore(SurveyResultDTO result, Map<String, String> resultMap) {
        int carboScore = 0;
        int proteinScore = 0;
        int fatScore = 0;
        int exerciseScore = 0;
        for(String resultMapKey : resultMap.keySet()){
            if(resultMapKey.contains("score")){
//                key = 카테고리(C,P,F,W) = value = 점수
                if(resultMapKey.contains("C")) {
                    carboScore = carboScore + Integer.parseInt(resultMap.get(resultMapKey));
                }
                if(resultMapKey.contains("P")) {
                    proteinScore = proteinScore + Integer.parseInt(resultMap.get(resultMapKey));
                }
                if(resultMapKey.contains("F")) {
                    fatScore = fatScore + Integer.parseInt(resultMap.get(resultMapKey));
                }
                if(resultMapKey.contains("E")) {
                    exerciseScore = exerciseScore + Integer.parseInt(resultMap.get(resultMapKey));
                }
            }
        }
        SurveyScoreRangeDTO range = mapper.getCurrentRange();   // 미완성 메소드
    }
}

