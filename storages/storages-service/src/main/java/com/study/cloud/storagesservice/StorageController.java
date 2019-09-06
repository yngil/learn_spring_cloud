package com.study.cloud.storagesservice;

import com.study.cloud.storagescommon.StorageInput;
import com.study.cloud.storagescommon.StorageOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storages")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/decrement")
    public boolean decrement(@RequestBody StorageInput storageInput){
        return storageService.decrement(storageInput);
    }

    @PostMapping("/checkProductCount")
    public boolean checkProductCount(@RequestBody StorageInput storageInput){
        return storageService.checkProductCount(storageInput);
    }

}
