package com.ohgiraffers.dosirak.user.customer.controller;

import com.ohgiraffers.dosirak.user.customer.model.dto.UserAskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserCustomerImgDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @GetMapping("/askRegist")
    public String getRegistPage() {
        return "user/customer/askRegist";
    }

    @PostMapping("/askRegist")
    public String testFileUpload(@RequestParam List<MultipartFile> attachImage,
                                 UserCustomerImgDTO imageDTO,
                                 UserAskDTO ask,
                                 Model model) {

        userCustomerService.askRegist(ask);

        int askCode = ask.getAskCode();

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

                    /* 리스트에 파일 정보 저장 */
                    imageList.add(fileInfo);

                    userCustomerService.registImage(fileInfo, askCode);
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
