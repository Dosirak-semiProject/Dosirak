package com.ohgiraffers.dosirak.user.survey.controller;

import com.ohgiraffers.dosirak.admin.login.model.AdminLoginDetails;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyQuestionDTO;
import com.ohgiraffers.dosirak.admin.survey.model.dto.SurveyResultDTO;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import com.ohgiraffers.dosirak.user.review.model.dto.UserDTO;
import com.ohgiraffers.dosirak.user.survey.model.survice.UserSurveyService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();

            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        int searchResult = service.checkSurveyResultByUserId(userId);
        if (searchResult != 0){
            SurveyResultDTO surveyResult = service.getSurveyResultByUserId(userId);
            System.out.println(surveyResult);
            Map userInfo = service.getUserInfoByUserId(userId);
            model.addAttribute("surveyResult",surveyResult);
            model.addAttribute("userInfo",userInfo);
            return "redirect:/survey/result";
        }
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
        service.setScore(result, resultMap);
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();

            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        result.setUserId(userId);
        int insertResult = service.setResult(result);
        return "redirect:/survey/result";
    }
    @GetMapping("result")
    public String result(Model model) {
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();
            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        SurveyResultDTO surveyResult = service.getSurveyResultByUserId(userId);
        Map userInfo = service.getUserInfoByUserId(userId);
        model.addAttribute("surveyResult",surveyResult);
        model.addAttribute("userInfo",userInfo);
        return "/user/survey/surveyResult";
    }
    @GetMapping("info-modify")
    public String infoModify(Model model) {
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();
            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        SurveyResultDTO surveyResult = service.getSurveyResultByUserId(userId);
        Map userInfo = service.getUserInfoByUserId(userId);
        model.addAttribute("surveyResult",surveyResult);
        model.addAttribute("userInfo",userInfo);
        model.addAttribute("condition", "modify");
        return "/user/survey/surveyInfo";
    }
    @PostMapping("modify")
    public String modify(Model model, SurveyResultDTO surveyResult) {
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();
            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        surveyResult.setUserId(userId);
        service.modifySurveyInfo(surveyResult);
        return "redirect:/survey/result";
    }
    @GetMapping("delete")
    public String delete(Model model) {
        String userId = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated()){
            Object principal = authentication.getPrincipal();
            if(principal instanceof AdminLoginDetails){
                AdminLoginDetails adminLoginDetails = (AdminLoginDetails) principal;
                LoginDTO login = adminLoginDetails.getLoginDTO();
                userId = login.getId();
            }
        }
        service.deleteSurvey(userId);
        return "redirect:/survey/agree";
    }
}
