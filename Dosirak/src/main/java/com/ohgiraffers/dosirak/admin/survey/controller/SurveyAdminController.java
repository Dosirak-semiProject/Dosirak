package com.ohgiraffers.dosirak.admin.survey.controller;

import com.ohgiraffers.dosirak.admin.survey.model.dto.*;
import com.ohgiraffers.dosirak.admin.survey.model.service.SurveyAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        model.addAttribute("rangeList", rangeList);
        return "admin/survey/surveyVersionView";
    }

    @GetMapping("version-delete")
    public String versionDelete(Model model, @RequestParam int versionId){
        int result = surveyAdminService.deleteVersionByVersionId(versionId);
        model.addAttribute("deleteResult", result);
        return "redirect:/admin/survey/version-list";
    }
}
