package com.study.cloud.services;

import com.study.cloud.products.common.ProductOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Products> findAllProducts(){
        return productDao.findAllProducts();
    }

    public Products findById(Integer productId){
        return productDao.findById(productId).orElseThrow(()->new IllegalArgumentException(String.format("产品id:%d,没有对应数据",productId)));
    }
}
