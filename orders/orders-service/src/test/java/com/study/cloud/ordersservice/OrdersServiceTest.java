package com.study.cloud.ordersservice;

import com.study.cloud.orderscommon.OrderInput;
import com.study.cloud.products.api.ProductService;
import com.study.cloud.products.common.ProductOutput;
import com.study.cloud.storages.api.StorageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {
    @MockBean
    private ProductService productService;
    @MockBean
    private StorageService storageService;
    @Autowired
    private OrdersService ordersService;

    @Before
    public void setUp() throws Exception {
        ProductOutput example = new ProductOutput();
        example.setPrice(new BigDecimal(10));
        example.setProductName("小A");
        example.setProductId(1);
        when(productService.findById(anyInt())).thenReturn(example);
        when(storageService.checkProductCount(any())).thenReturn(true);
        when(storageService.decrementById(any())).thenReturn(true);
    }

    @Test
    public void findOrders() {
        ;
    }

    @Test
    public void dealOrder() {
        OrderInput input = new OrderInput();
        input.setUserId(1);
        input.setProductId(11);
        boolean result = ordersService.dealOrder(input);
        Assert.isTrue(result,"");
    }

}