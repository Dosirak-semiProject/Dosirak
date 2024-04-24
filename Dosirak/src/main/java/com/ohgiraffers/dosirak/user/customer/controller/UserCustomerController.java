package com.ohgiraffers.dosirak.user.customer.controller;

import com.ohgiraffers.dosirak.admin.customer.model.dto.QnaDTO;
import com.ohgiraffers.dosirak.user.customer.model.dto.*;
import com.ohgiraffers.dosirak.user.customer.model.service.UserCustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Slf4j
@Controller
@RequestMapping("/user/customer")
public class UserCustomerController {

    @Value("${image.image-dir}")
    private String IMAGE_DIR;

    private final UserCustomerService userCustomerService;

    public UserCustomerController(UserCustomerService userCustomerService) {
        this.userCustomerService = userCustomerService;
    }


    /* ----- 고객센터 메인 ----- */

    @GetMapping("/main")
    public String getMainePage(Model model) {


        return "user/customer/main";
    }


    /* ----- 공지사항 ----- */

    @GetMapping("/noticeList")
    public String getNoticePage(Model model) {

        List<UserNoticeDTO> noticeList = userCustomerService.findNoticeList();

        model.addAttribute("noticeList", noticeList);

        return "user/customer/noticeList";
    }

    @GetMapping("/noticeDetail")
    public String getNoticeDetail(@RequestParam("noticeCode") int noticeCode, Model model) {

        UserNoticeDTO noticeDetail = userCustomerService.selectNoticeDetail(noticeCode);

        model.addAttribute("notice", noticeDetail);

        return "user/customer/noticeDetail";
    }


    /* ----- 자주 묻는 질문 ----- */

    @GetMapping("/qnaList")
    public String getQnaPage(Model model) {

        List<UserQnaDTO> qnaList = userCustomerService.findQnaList();

        model.addAttribute("qnaList", qnaList);

        return "user/customer/qnaList";
    }

    @GetMapping("/qnaDetail")
    public String getQnaDetail(@RequestParam("qnaCode") int qnaCode, Model model) {

        UserQnaDTO qnaDetail = userCustomerService.selectQnaDetail(qnaCode);
        List<UserAskCategoryDTO> categoryList = userCustomerService.findCategoryList();

        model.addAttribute("qna", qnaDetail);
        model.addAttribute("category", categoryList);

        return "user/customer/qnaDetail";
    }


    /* ----- 1대1 문의 ----- */

    @GetMapping("/askList")
    public String getAskPage(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(required = false) String searchCondition,
                             @RequestParam(required = false) String searchValue,
                             Model model) {

        log.info("boardList page : {}", page);
        log.info("boardList searchCondition : {}", searchCondition);
        log.info("boardList searchValue : {}", searchValue);

        Map<String, String> searchMap = new HashMap<>();
        searchMap.put("searchCondition", searchCondition);
        searchMap.put("searchValue", searchValue);

        Map<String, Object> askListAndPaging = userCustomerService.selectAskList(searchMap, page);
        model.addAttribute("paging", askListAndPaging.get("paging"));
        model.addAttribute("askList", askListAndPaging.get("askList"));

        return "user/customer/askList";
    }

    @GetMapping("/askDetail")
    public String getAskDetail(@RequestParam("askCode") int askCode, Model model) {

        UserAskDTO askDetail = userCustomerService.selectAskDetail(askCode);
        UserAnswerDTO answerDetail = userCustomerService.selectAnswerDetail(askCode);

        model.addAttribute("ask", askDetail);
        model.addAttribute("answer", answerDetail);

        return "user/customer/askDetail";
    }

    @GetMapping("/askRegist")
    public String getRegistPage() {

        return "user/customer/askRegist";
    }

    @PostMapping("/askRegist")
    public String testFileUpload(@RequestParam List<MultipartFile> attachImage,
                                 UserAskDTO ask,
                                 Model model) {

        userCustomerService.askRegist(ask);

        /* 경로 설정 */
        String fileUploadDir = IMAGE_DIR + "original";

        File dir1 = new File(fileUploadDir);

        /* 디렉토리가 없을 경우 생성한다. */
        if(!dir1.exists()) {
            dir1.mkdirs();
        }

        /* 업로드 파일에 대한 정보를 담을 리스트 */
        List<UserCustomerImgDTO> imageList = new ArrayList<>();

        try {
            for(int i = 0; i < attachImage.size(); i++) {
                /* 첨부파일이 실제로 존재하는 경우 로직 수행 */
                if(attachImage.get(i).getSize() > 0) {

                    String originalFileName = attachImage.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String saveFileName = UUID.randomUUID() + ext;
                    log.info("savedFileName : {}", saveFileName);

                    /* 서버의 설정 디렉토리에 파일 저장하기 */
                    attachImage.get(i).transferTo(new File(fileUploadDir + "/" + saveFileName));

                    /* DB에 저장할 파일의 정보 처리 */
                    UserCustomerImgDTO fileInfo = new UserCustomerImgDTO();
                    fileInfo.setOriginalName(originalFileName);
                    fileInfo.setSavedName(saveFileName);
                    fileInfo.setSavePath("/customerUpload/original");
                    fileInfo.setRefAskCode(ask.getAskCode());

                    /* 리스트에 파일 정보 저장 */
                    imageList.add(fileInfo);

                    userCustomerService.registImage(fileInfo);
                }
            }
            model.addAttribute("message", "파일 업로드에 성공하였습니다.");
        } catch (IOException e) {
            /* 파일 저장 중간에 실패 시, 이전에 저장된 파일 삭제 */
            for(UserCustomerImgDTO image : imageList) {
                new File(fileUploadDir + "/" + image.getSavedName()).delete();
            }
            model.addAttribute("message", "파일 업로드에 실패하였습니다.");
        }

        log.info("imageList : {}", imageList);

        return "user/customer/result";
    }
}
