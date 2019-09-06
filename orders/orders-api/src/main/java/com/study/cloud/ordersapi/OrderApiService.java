package com.study.cloud.ordersapi;

import com.study.cloud.orderscommon.OrderOutput;
import com.study.cloud.products.common.ProductInput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("orders")
public interface OrderApiService {
    @GetMapping("/orders/findOrders")
    List<OrderOutput> findOrders();
    @PostMapping("/orders/dealOrder")
    boolean dealOrder(ProductInput productInput);
}
