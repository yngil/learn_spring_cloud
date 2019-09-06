package com.study.cloud.storagesservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface StorageRepository extends CrudRepository<Storage,Integer> {
    @Modifying
    @Transactional
    @Query(value = "update storage set total_count = total_count-:sale_count,saled_count = saled_count+:sale_count,version = version+1 where storage_Id = :storageId and version = :version and total_count-:sale_count >= 0",nativeQuery = true)
    int derementById(@Param("storageId") Integer storageId,@Param("sale_count") Integer saleCount,Integer version);

    @Query("from Storage where productId = :productId")
    Storage findByProductId(@Param("productId") Integer productId);
}
