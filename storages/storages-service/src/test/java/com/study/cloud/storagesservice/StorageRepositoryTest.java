package com.study.cloud.storagesservice;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StorageRepositoryTest {

    @Autowired
    private StorageRepository storageRepository;

    @Test
    public void testDerementById() {
        int storageId = 1;
        int version = 1;
        int saleCount = 8;
        int resultCount = storageRepository.derementById(storageId,saleCount,version);
        Assert.assertSame(1,resultCount);
    }

    @Test
    public void testSave(){
        Storage storage = new Storage();
        storage.setProductId(1);
        storage.setTotalCount(10);
        storage.setSaledCount(0);
        storage.setCreateTime(new Date());
        storage.setUpdateTime(new Date());
        Storage result = storageRepository.save(storage);
        Assert.assertSame("",true,result!=null);
    }
}