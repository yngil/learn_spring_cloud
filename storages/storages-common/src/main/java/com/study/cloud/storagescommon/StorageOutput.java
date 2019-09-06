package com.study.cloud.storagescommon;

import lombok.Data;

@Data
public class StorageOutput {
    private Integer storageId;
    private Integer productId;
    private Integer totalCount;
    private Integer saledCount;
}
