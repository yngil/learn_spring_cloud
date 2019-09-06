package com.study.cloud.orderscommon;

import lombok.Data;

import java.util.Date;

@Data
public class OrderOutput {
    private String orderCode;
    private Date createTime;
}
