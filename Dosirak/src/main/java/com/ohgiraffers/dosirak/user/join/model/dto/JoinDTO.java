package com.ohgiraffers.dosirak.user.join.model.dto;

import java.util.Date;

public class JoinDTO implements java.io.Serializable {

    private String userId;
    private String userName;
    private Date userBirth;
    private char userGender;
    private String userPhone;
    private String userEmail;
    private String userAddress;
    private String userAgree;
    private String userPwd;
    private Date userJoinDate;

    public JoinDTO(){}

    public JoinDTO(String userId, String userName, Date userBirth, char userGender, String userPhone, String userEmail, String userAddress, String userAgree, String userPwd, Date userJoinDate) {
        this.userId = userId;
        this.userName = userName;
        this.userBirth = userBirth;
        this.userGender = userGender;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userAddress = userAddress;
        this.userAgree = userAgree;
        this.userPwd = userPwd;
        this.userJoinDate = userJoinDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public char getUserGender() {
        return userGender;
    }

    public void setUserGender(char userGender) {
        this.userGender = userGender;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAgree() {
        return userAgree;
    }

    public void setUserAgree(String userAgree) {
        this.userAgree = userAgree;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getUserJoinDate() {
        return userJoinDate;
    }

    public void setUserJoinDate(Date userJoinDate) {
        this.userJoinDate = userJoinDate;
    }

    @Override
    public String toString() {
        return "JoinDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userBirth=" + userBirth +
                ", userGender=" + userGender +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userAgree='" + userAgree + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userJoinDate=" + userJoinDate +
                '}';
    }
}
