package com.study.cloud.ordersservice;

import com.study.cloud.orderscommon.OrderInput;
import com.study.cloud.products.api.ProductService;
import com.study.cloud.products.common.ProductOutput;
import com.study.cloud.storages.api.StorageService;
import com.study.cloud.storagescommon.StorageInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepository ordersRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductService productService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private StorageService storageService;

    public List<Orders> findOrders(){
        return ordersRepository.findOrders();
    }

    public boolean dealOrder(OrderInput orderInput){
        // 获取产品信息
        ProductOutput productOutput = productService.findById(orderInput.getProductId());
        // 检查库存容量
        if(!checkProductCount(productOutput.getProductId(),1)){
            // TODO: 2019-09-06 待抛出详细异常
            throw new IllegalStateException("库存容量不足");
        }
        // 减库存
        if(!decrementStore(orderInput.getProductId(),1)){
            throw new IllegalStateException("减库存失败");
        }
        // 下单
        Orders order = new Orders();
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setOrderCode(UUID.randomUUID().toString());
        Optional<Orders> optional = Optional.ofNullable(ordersRepository.save(order));
        return optional.isPresent();
    }

    private boolean checkProductCount(Integer productId,Integer buyCount){
        StorageInput storageInput = new StorageInput();
        storageInput.setProductId(productId);
        storageInput.setBuyCount(buyCount);
        return storageService.checkProductCount(storageInput);
    }

    private boolean decrementStore(Integer productId,Integer buyCount){
        StorageInput storageInput = new StorageInput();
        storageInput.setProductId(productId);
        storageInput.setBuyCount(buyCount);
        return storageService.decrementById(storageInput);
    }
}
