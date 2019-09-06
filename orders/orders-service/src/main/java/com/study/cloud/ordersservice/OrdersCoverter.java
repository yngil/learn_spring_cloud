package com.study.cloud.ordersservice;

import com.study.cloud.orderscommon.OrderOutput;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrdersCoverter {
    public OrderOutput cover(Orders order){
        OrderOutput orderOutput = new OrderOutput();
        BeanUtils.copyProperties(order,orderOutput);
        return orderOutput;
    }
}
