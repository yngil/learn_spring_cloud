package com.study.cloud.services;

import com.study.cloud.products.common.ProductOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCoverter productCoverter;

    @GetMapping("/products/findAllProducts")
    public List<ProductOutput> findAllProducts(){
        return productService.findAllProducts().stream().map(products ->
                productCoverter.covert(products)).collect(Collectors.toList());
    }

    @GetMapping("/products/{id}")
    public ProductOutput find(@PathVariable("id") Integer productId){
        return productCoverter.covert(productService.findById(productId));
    }
}
