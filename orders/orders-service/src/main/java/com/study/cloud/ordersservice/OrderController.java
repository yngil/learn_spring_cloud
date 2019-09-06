package com.study.cloud.ordersservice;

import com.study.cloud.orderscommon.OrderInput;
import com.study.cloud.orderscommon.OrderOutput;
import com.study.cloud.products.common.ProductInput;
import com.study.cloud.storagescommon.StorageInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersCoverter ordersCoverter;

    @GetMapping("/findOrders")
    public List<OrderOutput> findOrders(){
        return ordersService.findOrders().stream().map(order->ordersCoverter.cover(order)).collect(Collectors.toList());
    }

    @PostMapping("/dealOrder")
    public boolean dealOrder(@RequestBody OrderInput orderInput){
        return ordersService.dealOrder(orderInput);
    }
}
