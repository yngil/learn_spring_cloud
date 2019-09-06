package com.study.cloud.products.common;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductOutput {
    private Integer productId;
    private String productName;
    private BigDecimal price;
}
