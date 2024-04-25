package com.ohgiraffers.dosirak.admin.product.controller;

import com.ohgiraffers.dosirak.admin.login.model.AdminLoginDetails;
import com.ohgiraffers.dosirak.admin.product.dto.ProductImageDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productAddImageDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import com.ohgiraffers.dosirak.admin.product.service.ProductService;
import com.ohgiraffers.dosirak.common.product.ProductUpdateException;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserAskDTO;
import com.ohgiraffers.dosirak.user.customer.model.dto.UserCustomerImgDTO;
import com.ohgiraffers.dosirak.user.customer.model.service.UserCustomerService;
import com.ohgiraffers.dosirak.user.login.model.dto.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@Slf4j
@RequestMapping("/admin/product/*")
public class ProductController {

    private final ProductService productService;
    private final UserCustomerService userCustomerService;

    @Value("${image.product-image-dir}")
    private String IMAGE_DIR;


    @Autowired
    public ProductController(ProductService productService, UserCustomerService userCustomerService) {
        this.productService = productService;
        this.userCustomerService = userCustomerService;
    }

    @GetMapping("/productList")
    public String productList(Model model) {
        List<productDTO> productList = productService.findAllProduct();
        model.addAttribute("productList", productList);
        return "/admin/product/productList";
    }

    @PostMapping("/product/search")
    public String productSelectList(@RequestParam String key, Model model) {
        List<productDTO> productList = productService.productSelectList(key);
        model.addAttribute("productList", productList);
        return "/admin/product/productList";
    }

    @PostMapping("/add")
    public String addProduct(productDTO product, @RequestParam List<MultipartFile> productImage, Model model) {
        // 상품 정보 저장

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof AdminLoginDetails adminLoginDetails) {
                LoginDTO login = adminLoginDetails.getLoginDTO();
                String userId = login.getId();

                /* 질문 등록하기 */
                productDTO newproduct = new productDTO();
                newproduct.setProductName(product.getProductName());
                newproduct.setProductPrice(product.getProductPrice());
                newproduct.setProductStatus(product.getProductStatus());
                newproduct.setProductSummary(product.getProductSummary());
                newproduct.setProductCategoryCode(product.getProductCategoryCode());
                productService.insertProduction(newproduct);

                /* 가장 최신 질문 조회 */
//                UserAskDTO lastAsk = productService.findLastAsk();
//                log.info("lastAsk : {}", lastAsk);
                productDTO lastProduct = productService.codePlz();
                log.info("lastProduct: {}", lastProduct);
                System.out.println(lastProduct);

                /* 경로 설정 */
//                String fileUploadDir = IMAGE_DIR + "original";
                String root = "src/main/resources/productUpload";
                String fileUploadDir = root + "/original";

                File dir1 = new File(fileUploadDir);

                /* 디렉토리가 없을 경우 생성한다. */
                if (!dir1.exists()) {
                    dir1.mkdirs();
                }

                /* 업로드 파일에 대한 정보를 담을 리스트 */
                List<ProductImageDTO> imageList = new ArrayList<>();

                try {
                    for (MultipartFile file : productImage) {
                        /* 첨부파일이 실제로 존재하는 경우 로직 수행 */


                        String originalFileName = file.getOriginalFilename();
                        log.info("originalFileName : {}", originalFileName);
                        String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                        String saveFileName = UUID.randomUUID() + ext;
                        log.info("savedFileName : {}", saveFileName);



                        imageList.add(new ProductImageDTO(lastProduct,saveFileName, productImage));
                        /* 서버의 설정 디렉토리에 파일 저장하기 */
                        file.transferTo(new File(fileUploadDir + "/" + saveFileName));

                        /* DB에 저장할 파일의 정보 처리 */
                        ProductImageDTO fileInfo = new ProductImageDTO();
                        fileInfo.setSavedName(saveFileName);
                        fileInfo.setSavePath("/static/customerUpload/original");

                        /* 이미지 DTO에 요청 코드 설정 */
                        fileInfo.setProductCode(lastProduct.getProductCode());

                        /* 리스트에 파일 정보 저장 */
//                        imageList.add(fileInfo);
                        log.info("imageList : {}", imageList);
                    }

                    /* 이미지 리스트를 한 번에 DB에 저장 */
                    productService.registImageList(imageList);

                    model.addAttribute("message", "파일 업로드에 성공하였습니다.");

                } catch (IOException e) {
                    /* 파일 저장 중간에 실패 시, 이전에 저장된 파일 삭제 */
                    for (ProductImageDTO image : imageList) {
                        new File(fileUploadDir + "/" + image.getSavedName()).delete();
                    }
                    model.addAttribute("message", "파일 업로드에 실패하였습니다.");
                }
                log.info("imageList : {}", imageList);
            }



        }            return "redirect:/admin/product/productList";

    }


    //    파라미터 넘긴 방식이 Get 인데 PostMapping 되어있었음
//    html 링크에서 /admin 명시 안되어있음
//    view페이지 오류 ex) 찾을수없는값 있을경우
    @GetMapping("/productView")
    public String productView(@RequestParam("productCode") int productCode, Model model) {
        model.addAttribute("setCondition", "modifyProduct");
        System.out.println(productCode);
        productDTO product = productService.getProductByCode(productCode);
        model.addAttribute("product", product);
        System.out.println(product);
        return "/admin/product/productView";
    }

    @GetMapping("/nullProductView")
    public String getProductViewPage(Model model) {
        model.addAttribute("setCondition", "addProduct");
        return "/admin/product/productView";
    }

    @PostMapping("/productUpdate")
    public String productUpdate(productDTO product, int productCode,
                                @RequestParam List<MultipartFile> productImage,
                                Model model) throws ProductUpdateException {
        productService.productUpdate(product);

        /* 경로 설정 */
        String fileUploadDir = IMAGE_DIR + "original";

        File dir1 = new File(fileUploadDir);

        /* 디렉토리가 없을 경우 생성한다. */
        if (!dir1.exists()) {
            dir1.mkdirs();
        }

        /* 업로드 파일에 대한 정보를 담을 리스트 */
        List<ProductImageDTO> imageList = new ArrayList<>();

        try {
            for (int i = 0; i < productImage.size(); i++) {
                /* 첨부파일이 실제로 존재하는 경우 로직 수행 */
                if (productImage.get(i).getSize() > 0) {
                    System.out.println(productImage.get(i));
                    String originalFileName = productImage.get(i).getOriginalFilename();
                    log.info("originalFileName : {}", originalFileName);

                    String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
                    String saveFileName = UUID.randomUUID() + ext;
                    log.info("savedFileName : {}", saveFileName);

                    /* 서버의 설정 디렉토리에 파일 저장하기 */
                    productImage.get(i).transferTo(new File(fileUploadDir + "/" + saveFileName));

                    /* DB에 저장할 파일의 정보 처리 */
                    ProductImageDTO fileInfo = new ProductImageDTO();
                    fileInfo.setSavedName(saveFileName);
                    fileInfo.setSavePath("/static/customerUpload/original");

                    log.info("productCode : {}", productCode);
                    /* 이미지 DTO에 요청 코드 설정 */
                    fileInfo.setProductCode(productCode);
                    log.info("fileInfo : {}", fileInfo);

                    /* 리스트에 파일 정보 저장 */
                    imageList.add(fileInfo);
                    log.info("imageList : {}", imageList);
                }
            }
            /* 이미지 리스트를 한 번에 DB에 저장 */
            productService.registImageList(imageList);


        } catch (IOException e) {
            /* 파일 저장 중간에 실패 시, 이전에 저장된 파일 삭제 */
            for (ProductImageDTO image : imageList) {
                new File(fileUploadDir + "/" + image.getSavedName()).delete();
            }
            System.out.println("실패");
        }
        log.info("imageList : {}", imageList);

        return "redirect:/admin/product/productList";
    }

}



