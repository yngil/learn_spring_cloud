package com.study.cloud.ordersservice;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="orders")
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;
    @Column(name = "order_code",nullable = false)
    private String orderCode;
    @Column(name = "create_time",nullable = false)
    private Date createTime;
    @Column(name = "update_time",nullable = false)
    private Date updateTime;
}
