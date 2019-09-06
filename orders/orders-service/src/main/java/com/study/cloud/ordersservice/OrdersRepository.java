package com.study.cloud.ordersservice;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends CrudRepository<Orders,Integer> {
    @Query("select o from Orders o")
    List<Orders> findOrders();
}
