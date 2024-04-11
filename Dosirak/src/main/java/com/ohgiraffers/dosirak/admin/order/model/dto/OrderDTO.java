package com.ohgiraffers.dosirak.admin.order.model.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {

    private int order_code;
    private String order_status;
    private String user_nameAndId;
    private String order_recipient;
    private int pay_price;
    private Date pay_date;
    private boolean pay_status;
    private String pay_method;
}
