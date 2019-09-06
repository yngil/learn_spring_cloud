package com.study.cloud.storages.api;

import com.study.cloud.storagescommon.StorageInput;
import com.study.cloud.storagescommon.StorageOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("storages-service")
public interface StorageService {
    @PostMapping("/storages/decrement")
    boolean decrementById(@RequestBody StorageInput storageInput);
    @PostMapping("/storages/checkProductCount")
    boolean checkProductCount(@RequestBody StorageInput storageInput);
}
