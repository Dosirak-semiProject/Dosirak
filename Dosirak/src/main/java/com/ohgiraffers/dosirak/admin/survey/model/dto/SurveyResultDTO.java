package com.ohgiraffers.dosirak.admin.survey.model.dto;

import java.sql.Date;

public class SurveyResultDTO {
    private String userId;  //UserDTO 로 변경
    private double surveyHeight;
    private double surveyWeight;
    private double surveyBmi;
    private String surveyDiet;
    private int surveyExscore;
    private double surveyCarbo;
    private double surveyProtein;
    private double surveyFat;
    private double surveyCalory;
    private boolean surveyDiabetes;
    private boolean surveyCancer;
    private boolean surveyKidney;
    private boolean surveyBlood;
    private java.sql.Date surveyDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getSurveyHeight() {
        return surveyHeight;
    }

    public void setSurveyHeight(double surveyHeight) {
        this.surveyHeight = surveyHeight;
    }

    public double getSurveyWeight() {
        return surveyWeight;
    }

    public void setSurveyWeight(double surveyWeight) {
        this.surveyWeight = surveyWeight;
    }

    public double getSurveyBmi() {
        return surveyBmi;
    }

    public void setSurveyBmi(double surveyBmi) {
        this.surveyBmi = surveyBmi;
    }

    public String getSurveyDiet() {
        return surveyDiet;
    }

    public void setSurveyDiet(String surveyDiet) {
        this.surveyDiet = surveyDiet;
    }

    public int getSurveyExscore() {
        return surveyExscore;
    }

    public void setSurveyExscore(int surveyExscore) {
        this.surveyExscore = surveyExscore;
    }

    public double getSurveyCarbo() {
        return surveyCarbo;
    }

    public void setSurveyCarbo(double surveyCarbo) {
        this.surveyCarbo = surveyCarbo;
    }

    public double getSurveyProtein() {
        return surveyProtein;
    }

    public void setSurveyProtein(double surveyProtein) {
        this.surveyProtein = surveyProtein;
    }

    public double getSurveyFat() {
        return surveyFat;
    }

    public void setSurveyFat(double surveyFat) {
        this.surveyFat = surveyFat;
    }

    public double getSurveyCalory() {
        return surveyCalory;
    }

    public void setSurveyCalory(double surveyCalory) {
        this.surveyCalory = surveyCalory;
    }

    public boolean isSurveyDiabetes() {
        return surveyDiabetes;
    }

    public void setSurveyDiabetes(boolean surveyDiabetes) {
        this.surveyDiabetes = surveyDiabetes;
    }

    public boolean isSurveyCancer() {
        return surveyCancer;
    }

    public void setSurveyCancer(boolean surveyCancer) {
        this.surveyCancer = surveyCancer;
    }

    public boolean isSurveyKidney() {
        return surveyKidney;
    }

    public void setSurveyKidney(boolean surveyKidney) {
        this.surveyKidney = surveyKidney;
    }

    public boolean isSurveyBlood() {
        return surveyBlood;
    }

    public void setSurveyBlood(boolean surveyBlood) {
        this.surveyBlood = surveyBlood;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    @Override
    public String toString() {
        return "SurveyResultDTO{" +
                "userId='" + userId + '\'' +
                ", surveyHeight=" + surveyHeight +
                ", surveyWeight=" + surveyWeight +
                ", surveyBmi=" + surveyBmi +
                ", surveyDiet='" + surveyDiet + '\'' +
                ", surveyExscore=" + surveyExscore +
                ", surveyCarbo=" + surveyCarbo +
                ", surveyProtein=" + surveyProtein +
                ", surveyFat=" + surveyFat +
                ", surveyCalory=" + surveyCalory +
                ", surveyDiabetes=" + surveyDiabetes +
                ", surveyCancer=" + surveyCancer +
                ", surveyKidney=" + surveyKidney +
                ", surveyBlood=" + surveyBlood +
                ", surveyDate=" + surveyDate +
                '}';
    }
}
