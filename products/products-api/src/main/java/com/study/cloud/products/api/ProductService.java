package com.study.cloud.products.api;

import com.study.cloud.products.common.ProductInput;
import com.study.cloud.products.common.ProductOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("products-service")
public interface ProductService {
    @GetMapping("/products/findAllProducts")
    List<ProductOutput> findAllProducts();
    @GetMapping("/products/{id}")
    ProductOutput findById(@PathVariable("id") Integer productId);
}
