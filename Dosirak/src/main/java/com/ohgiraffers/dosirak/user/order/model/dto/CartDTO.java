package com.ohgiraffers.dosirak.user.order.model.dto;

import com.ohgiraffers.dosirak.admin.member.model.dto.MemberDTO;
import com.ohgiraffers.dosirak.admin.order.model.dto.PayDTO;
import com.ohgiraffers.dosirak.admin.product.dto.productDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartDTO {

    private int cartitemCount;
    private String id;
    private int productCode;
    private int suitboxCode;
    private productDTO productDTO;
    private PayDTO payDTO;
    private MemberDTO memberDTO;

    public CartDTO() {}

    public CartDTO(int cartitemCount, String id, int productCode, int suitboxCode, com.ohgiraffers.dosirak.admin.product.dto.productDTO productDTO, PayDTO payDTO, MemberDTO memberDTO) {
        this.cartitemCount = cartitemCount;
        this.id = id;
        this.productCode = productCode;
        this.suitboxCode = suitboxCode;
        this.productDTO = productDTO;
        this.payDTO = payDTO;
        this.memberDTO = memberDTO;
    }
}
