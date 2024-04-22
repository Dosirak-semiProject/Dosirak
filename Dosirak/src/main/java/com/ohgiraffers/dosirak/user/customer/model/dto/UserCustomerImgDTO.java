package com.ohgiraffers.dosirak.user.customer.model.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserCustomerImgDTO {

    private int imgNO;
    private int refAskCode;
    private String originalName;
    private String savedName;
    private String savePath;
    private String fileType;
    private String thumbNailPath;
    private String attachmentStatus;

    public UserCustomerImgDTO() {};

    public UserCustomerImgDTO(int imgNO, int refAskCode, String originalName, String savedName, String savePath, String fileType, String thumbNailPath, String attachmentStatus) {
        this.imgNO = imgNO;
        this.refAskCode = refAskCode;
        this.originalName = originalName;
        this.savedName = savedName;
        this.savePath = savePath;
        this.fileType = fileType;
        this.thumbNailPath = thumbNailPath;
        this.attachmentStatus = attachmentStatus;
    }
}

