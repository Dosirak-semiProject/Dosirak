package com.ohgiraffers.dosirak.user.customer.model.service;


import com.ohgiraffers.dosirak.admin.customer.model.dto.AskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dao.UserCustomerMapper;
import com.ohgiraffers.dosirak.user.customer.model.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCustomerService {

    private final UserCustomerMapper userCustomerMapper;

    public UserCustomerService(UserCustomerMapper userCustomerMapper) {
        this.userCustomerMapper = userCustomerMapper;
    }


    /* ----- 공지사항 ----- */

    public List<UserNoticeDTO> findNoticeList() {

        return userCustomerMapper.findNoticeList();
    }

    public UserNoticeDTO selectNoticeDetail(int noticeCode) {

        /* 공지사항 상세 내용 조회 후 리턴 */
        return userCustomerMapper.searchNoticeDetail(noticeCode);
    }


    /* ----- 자주 묻는 질문 ----- */

    public List<UserQnaDTO> findQnaList() {

        /* 자주 묻는 질문 조회 후 반환 */
        return userCustomerMapper.findQnaList();
    }

    public UserQnaDTO selectQnaDetail(int qnaCode) {

        /* 자주 묻는 질문 및 답변 상세 내용 조회 후 리턴 */
        return userCustomerMapper.searchQnaDetail(qnaCode);
    }
    public List<UserAskCategoryDTO> findCategoryList() {

        return userCustomerMapper.findCategoryList();
    }

    /* ----- 1대1 문의 ----- */

    public List<UserAskDTO> findAskList() {

        /* 1대1 문의 조회 후 반환 */
        return userCustomerMapper.findAskList();
    }

    public UserAskDTO selectAskDetail(int askCode) {

        return userCustomerMapper.searchAskDetail(askCode);
    }

    public void registThumnail(AskDTO ask) {

        /* UserCustomerImag 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        ask.getImageList().forEach(UserCustomerImgDTO -> {
            UserCustomerImgDTO.setRefAskCode(ask.getAskCode());
            userCustomerMapper.insertAttachment(UserCustomerImgDTO);
        });
    }

    public void askRegist(UserAskDTO ask) {

        userCustomerMapper.insertAsk(ask);
    }

    public void registImage(UserCustomerImgDTO fileInfo, int askCode) {

        userCustomerMapper.insertImage(fileInfo, askCode);
    }


}
