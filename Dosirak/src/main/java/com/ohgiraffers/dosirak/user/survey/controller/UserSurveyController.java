package com.ohgiraffers.dosirak.user.survey.controller;

import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import com.ohgiraffers.dosirak.user.survey.model.survice.UserSurveyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RequestMapping("survey")
@Controller
public class UserSurveyController {
    final private UserSurveyService service;
    public UserSurveyController(UserSurveyService service) {
        this.service = service;
    }

    @GetMapping("agree")
    public String survey(Model model) {
        return "user/survey/surveyAgree";
    }
    @PostMapping("info")
    public String surveyInfo(Model model) {
        return "user/survey/surveyInfo";
    }
    @PostMapping("nutrition")
    public String test3(Model model, SurveyResultDTO infoResult) {
        List<SurveyQuestionDTO> currentVersion = service.getCurrentSurvey();
        model.addAttribute("questionList", currentVersion);
        model.addAttribute("infoResult", infoResult);
        return "/user/survey/surveyMain";
    }
    @PostMapping("submit-survey")
    public String test4(Model model, SurveyResultDTO result, @RequestParam Map<String , String > resultMap) {
        System.out.println(resultMap);

        service.setScore(result, resultMap);
        return "/user/survey/surveyResult";
    }

}
