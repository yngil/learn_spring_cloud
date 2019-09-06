package com.study.cloud.services;

import com.study.cloud.products.common.ProductOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductCoverter {
    public ProductOutput covert(Products product){
        ProductOutput output = new ProductOutput();
        BeanUtils.copyProperties(product,output);
        return output;
    }
}
