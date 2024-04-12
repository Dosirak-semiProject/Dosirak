package com.ohgiraffers.dosirak.admin.customer.model.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


public class NoticeDTO {

    private int noticeCode;
    private String noticeTitle;
    private String noticeContent;
    private LocalDateTime noticeDate;
    private String adminId;

    public NoticeDTO() {}

    public NoticeDTO(int noticeCode, String noticeTitle, String noticeContent, LocalDateTime noticeDate, String adminId) {

        this.noticeCode = noticeCode;
        this.noticeTitle = noticeTitle;
        this.noticeContent = noticeContent;
        this.noticeDate = noticeDate;
        this.adminId = adminId;
    }

    public int getNoticeCode() {
        return noticeCode;
    }

    public void setNoticeCode(int noticeCode) {
        this.noticeCode = noticeCode;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public LocalDateTime getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(LocalDateTime noticeDate) {
        this.noticeDate = noticeDate;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "noticeCode=" + noticeCode +
                ", noticeTitle='" + noticeTitle + '\'' +
                ", noticeContent='" + noticeContent + '\'' +
                ", noticeDate=" + noticeDate +
                ", adminId='" + adminId + '\'' +
                '}';
    }
}
