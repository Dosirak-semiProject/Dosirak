package com.ohgiraffers.dosirak.admin.member.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MemberDTO {
    private String id;
    private String name;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birth;
    private char gender;
    private String phone;
    private String email;
    private String address;
    private String agree;
    private String pwd;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date joindate;
    private boolean withdrawal;
    private String role;

    public MemberDTO(){}

    public MemberDTO(String id, String name, Date birth, char gender, String phone, String email, String address, String agree, String pwd, Date joindate, boolean withdrawal, String role) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.agree = agree;
        this.pwd = pwd;
        this.joindate = joindate;
        this.withdrawal = withdrawal;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAgree() {
        return agree;
    }

    public void setAgree(String agree) {
        this.agree = agree;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getJoindate() {
        return joindate;
    }

    public void setJoindate(Date joindate) {
        this.joindate = joindate;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.withdrawal = withdrawal;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", agree='" + agree + '\'' +
                ", pwd='" + pwd + '\'' +
                ", joindate=" + joindate +
                ", withdrawal=" + withdrawal +
                ", role='" + role + '\'' +
                '}';
    }
}
