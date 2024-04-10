package com.ohgiraffers.dosirak.user.login.model.dto;

import com.ohgiraffers.dosirak.common.UserRole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginDTO implements java.io.Serializable {

    private String userId;
    private String userName;
    private String userPwd;
    private UserRole userRole;

    public LoginDTO() {}

    public LoginDTO(String userId, String userName, String userPwd, UserRole userRole) {
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userRole = userRole;
    }

    public List<String> getRole() {
        if(this.userRole.getRole().length() > 0) return Arrays.asList(this.userRole.getRole().split(","));
        return new ArrayList<>();
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

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}
