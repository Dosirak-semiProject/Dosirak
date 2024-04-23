package com.ohgiraffers.dosirak.user.customer.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


public class UserCustomerImgDTO {

    private int imgNO;
    private int refAskCode;
    private String originalName;
    private String savedName;
    private String savePath;
    private String fileType;
    private String thumbNailPath;
    private String attachmentStatus;

    public UserCustomerImgDTO() {}

    public int getImgNO() {
        return imgNO;
    }

    public void setImgNO(int imgNO) {
        this.imgNO = imgNO;
    }

    public int getRefAskCode() {
        return refAskCode;
    }

    public void setRefAskCode(int refAskCode) {
        this.refAskCode = refAskCode;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getSavedName() {
        return savedName;
    }

    public void setSavedName(String savedName) {
        this.savedName = savedName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getThumbNailPath() {
        return thumbNailPath;
    }

    public void setThumbNailPath(String thumbNailPath) {
        this.thumbNailPath = thumbNailPath;
    }

    public String getAttachmentStatus() {
        return attachmentStatus;
    }

    public void setAttachmentStatus(String attachmentStatus) {
        this.attachmentStatus = attachmentStatus;
    }

    @Override
    public String toString() {
        return "UserCustomerImgDTO{" +
                "imgNO=" + imgNO +
                ", refAskCode=" + refAskCode +
                ", originalName='" + originalName + '\'' +
                ", savedName='" + savedName + '\'' +
                ", savePath='" + savePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", thumbNailPath='" + thumbNailPath + '\'' +
                ", attachmentStatus='" + attachmentStatus + '\'' +
                '}';
    }
}

