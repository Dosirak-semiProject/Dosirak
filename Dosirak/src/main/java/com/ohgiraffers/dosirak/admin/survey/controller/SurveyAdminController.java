package com.ohgiraffers.dosirak.admin.survey.controller;

import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyCategoryRangeDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyVersionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.service.SurveyAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/survey")
public class SurveyAdminController {
    private final SurveyAdminService surveyAdminService;
    public SurveyAdminController(SurveyAdminService surveyAdminService) {
        this.surveyAdminService = surveyAdminService;
    }

    @GetMapping("result-list")
    public String resultList(Model model){
        model.addAttribute("surveyList", surveyAdminService.surveyList());
        return "admin/survey/surveyList";
    }
    @GetMapping("version-list")
    public String versionList(Model model){
        List<SurveyVersionDTO> versionList = surveyAdminService.getAllVersion();
        model.addAttribute("versionList", versionList);
        return "admin/survey/surveyVersionList";
    }
    @GetMapping("version-detail")
    public String versionList(Model model, @RequestParam int versionId){
        SurveyVersionDTO version = surveyAdminService.getVersionByVersionId(versionId);
        List<SurveyQuestionDTO> questionList = surveyAdminService.getQuestionListByVersionId(versionId);
        List<SurveyCategoryRangeDTO> rangeList = surveyAdminService.getRangeListByVersionId(versionId);
        model.addAttribute("version", version);
        model.addAttribute("questionList", questionList);
        return "admin/survey/surveyVersionView";
    }
}
