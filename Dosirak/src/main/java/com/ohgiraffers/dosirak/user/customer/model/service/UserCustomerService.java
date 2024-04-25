package com.ohgiraffers.dosirak.user.customer.model.service;


import com.ohgiraffers.dosirak.admin.customer.model.dto.AskDTO;
import com.ohgiraffers.dosirak.user.customer.common.Pagenation;
import com.ohgiraffers.dosirak.user.customer.common.SelectCriteria;
import com.ohgiraffers.dosirak.user.customer.model.dao.UserCustomerMapper;
import com.ohgiraffers.dosirak.user.customer.model.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
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

    public UserAnswerDTO selectAnswerDetail(int askCode) {

        return userCustomerMapper.searchAnswerDetail(askCode);
    }

    public void registThumnail(AskDTO ask) {

        /* UserCustomerImag 테이블에 데이터 저장 (첨부 파일 개수 만큼) */
        ask.getImageList().forEach(UserCustomerImgDTO -> {
            UserCustomerImgDTO.setRefAskCode(ask.getAskCode());
            userCustomerMapper.insertAttachment(UserCustomerImgDTO);
        });
    }

    public void askRegist(UserAskDTO askCode) {

        userCustomerMapper.insertAsk(askCode);
    }

    @Transactional
    public void registImage(UserCustomerImgDTO fileInfo) {

        userCustomerMapper.insertImage(fileInfo);
    }


    public Map<String, Object> selectAskList(Map<String, String> searchMap, int page) {

        /* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리를 위해 */
        int totalCount = userCustomerMapper.selectTotalCount(searchMap);
        log.info("askList totalCount : {}", totalCount);

        /* 2. 페이징 처리와 연관 된 값을 계산하여 SelectCriteria 타입의 객체에 담는다. */
        int limit = 10;         // 한 페이지에 보여줄 게시물의 수
        int buttonAmount = 5;   // 한 번에 보여질 페이징 버튼의 수
        SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
        log.info("askList selectCriteria : {}", selectCriteria);


        /* 3. 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다. */
        List<UserAskDTO> askList = userCustomerMapper.selectAskList(selectCriteria);
        log.info("askList : {}", askList);

        Map<String, Object> askListAndPaging = new HashMap<>();
        askListAndPaging.put("paging", selectCriteria);
        askListAndPaging.put("askList", askList);

        return askListAndPaging;
    }


    public UserAskDTO findLastAsk() {

        /* 가장 최신 1대1 문의 조회 후 반환 */
        return userCustomerMapper.searchLastAsk();
    }
}
