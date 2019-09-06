package com.study.cloud.storagesservice;

import com.study.cloud.storagescommon.StorageInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StorageService {
    @Autowired
    private StorageRepository storageRepository;

    @Transactional
    public boolean decrement(StorageInput storageInput){
        checkParam(storageInput);
        Storage storage = findByProductId(storageInput.getProductId());
        int count = storageRepository.derementById(storage.getStorageId(),storageInput.getBuyCount(),storage.getVersion());
        return count==1;
    }

    private boolean checkParam(StorageInput storageInput){
        Storage storage = findByProductId(storageInput.getProductId());
        if(storageInput.getBuyCount()<1){
            throw new IllegalArgumentException("购买数量小于1");
        }
        return true;
    }

    public boolean checkProductCount(StorageInput storageInput){
        Storage storage = findByProductId(storageInput.getProductId());
        return storage.getTotalCount()>=storageInput.getBuyCount();
    }

    public Storage findByProductId(Integer productId){
        Storage storage = storageRepository.findByProductId(productId);
        if(null==storage){
            throw new IllegalArgumentException("商品库存不存在");
        }
        return storage;
    }
}
