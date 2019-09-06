package com.study.cloud.storagesservice;

import com.study.cloud.storagescommon.StorageInput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageServiceTest {
    @Autowired
    private StorageService storageService;

    @Test
    public void decrement() {
        StorageInput storageInput = new StorageInput();
        storageInput.setBuyCount(1);
        storageInput.setProductId(1);
        boolean result = storageService.decrement(storageInput);
        Assert.assertSame(true,result);
    }

    @Test
    public void checkProductCount() {
        StorageInput storageInput = new StorageInput();
        storageInput.setBuyCount(1);
        storageInput.setProductId(1);
        boolean result = storageService.checkProductCount(storageInput);
        Assert.assertSame(true,result);
    }
}