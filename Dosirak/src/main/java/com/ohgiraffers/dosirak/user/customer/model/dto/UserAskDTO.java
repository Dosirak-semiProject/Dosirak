package com.ohgiraffers.dosirak.user.customer.model.dto;

import com.ohgiraffers.dosirak.admin.customer.model.dto.AnswerDTO;
import com.ohgiraffers.dosirak.admin.customer.model.dto.AskCategoryDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public class UserAskDTO {

    public int getAskCode() {
        return askCode;
    }

    public void setAskCode(int askCode) {
        this.askCode = askCode;
    }

    public String getAskTitle() {
        return askTitle;
    }

    public void setAskTitle(String askTitle) {
        this.askTitle = askTitle;
    }

    public String getAskContent() {
        return askContent;
    }

    public void setAskContent(String askContent) {
        this.askContent = askContent;
    }

    public LocalDateTime getAskDate() {
        return askDate;
    }

    public void setAskDate(LocalDateTime askDate) {
        this.askDate = askDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getEditDate() {
        return editDate;
    }

    public void setEditDate(LocalDateTime editDate) {
        this.editDate = editDate;
    }

    public Boolean getAskDelete() {
        return askDelete;
    }

    public void setAskDelete(Boolean askDelete) {
        this.askDelete = askDelete;
    }

    public int getAskCategoryCode() {
        return askCategoryCode;
    }

    public void setAskCategoryCode(int askCategoryCode) {
        this.askCategoryCode = askCategoryCode;
    }

    public UserAnswerDTO getAnswerDTO() {
        return answerDTO;
    }

    public void setAnswerDTO(UserAnswerDTO answerDTO) {
        this.answerDTO = answerDTO;
    }

    public UserAskCategoryDTO getAskCategoryDTO() {
        return askCategoryDTO;
    }

    public void setAskCategoryDTO(UserAskCategoryDTO askCategoryDTO) {
        this.askCategoryDTO = askCategoryDTO;
    }

    public List<UserCustomerImgDTO> getImageList() {
        return imageList;
    }

    public void setImageList(List<UserCustomerImgDTO> imageList) {
        this.imageList = imageList;
    }

    private int askCode;
    private String askTitle;
    private String askContent;
    private LocalDateTime askDate;
    private String userId;
    private LocalDateTime editDate;
    private Boolean askDelete;
    private int askCategoryCode; // 추후 수정

    private UserAnswerDTO answerDTO;
    private UserAskCategoryDTO askCategoryDTO;

    private List<UserCustomerImgDTO> imageList;

    public UserAskDTO() {}

    public UserAskDTO(int askCode, String askTitle, String askContent, LocalDateTime askDate, String userId, LocalDateTime editDate, Boolean askDelete, int askCategoryCode, UserAnswerDTO answerDTO, UserAskCategoryDTO askCategoryDTO, List<UserCustomerImgDTO> imageList) {
        this.askCode = askCode;
        this.askTitle = askTitle;
        this.askContent = askContent;
        this.askDate = askDate;
        this.userId = userId;
        this.editDate = editDate;
        this.askDelete = askDelete;
        this.askCategoryCode = askCategoryCode;
        this.answerDTO = answerDTO;
        this.askCategoryDTO = askCategoryDTO;
        this.imageList = imageList;
    }

    @Override
    public String toString() {
        return "UserAskDTO{" +
                "askCode=" + askCode +
                ", askTitle='" + askTitle + '\'' +
                ", askContent='" + askContent + '\'' +
                ", askDate=" + askDate +
                ", userId='" + userId + '\'' +
                ", editDate=" + editDate +
                ", askDelete=" + askDelete +
                ", askCategoryCode=" + askCategoryCode +
                ", answerDTO=" + answerDTO +
                ", askCategoryDTO=" + askCategoryDTO +
                ", imageList=" + imageList +
                '}';
    }
}
