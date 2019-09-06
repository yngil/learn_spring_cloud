package com.study.cloud.ordersservice;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class OrdersRepositoryTest extends OrdersServiceApplicationTests {
    @Autowired
    private OrdersRepository ordersRepository;

    @Test
    public void testFindOrders() {
        List<Orders> list = ordersRepository.findOrders();
        Assert.isTrue(list.size()==0,"加载订单列表数量与期望不符");
    }

    @Test
    public void testSave(){
        Orders order = new Orders();
        order.setOrderCode("112233");
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        Orders result = ordersRepository.save(order);
        Assert.isTrue(result!=null,"保存订单失败");
    }
}