package com.study.cloud.services;

import com.study.cloud.products.common.ProductOutput;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
public class ProductServiceTest extends BaseTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findAllProducts() {
        List<Products> result = productService.findAllProducts();
        Assert.notEmpty(result,"获取全部产品列表失败");
        Assert.isTrue(result.size()==2,"全部列表数量与期待不符");
        log.info("产品列表:{}",result.size());
        result.stream().forEach(products -> {
            log.info("ProductName:{},Price:{}",products.getProductName(),products.getPrice());
        });
    }

    @Test
    public void findById() {
        Integer productId = 1;
        Products products =  productService.findById(productId);
        Assert.isTrue(products!=null,"产品id加载记录失败");
    }
}