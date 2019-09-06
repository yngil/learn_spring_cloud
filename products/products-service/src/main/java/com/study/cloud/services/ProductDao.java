package com.study.cloud.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Products,Integer> {
    @Query("select p from Products p")
    List<Products> findAllProducts();
}
