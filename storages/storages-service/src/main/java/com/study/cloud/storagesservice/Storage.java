package com.study.cloud.storagesservice;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="storage")
@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="storage_id")
    private Integer storageId;
    @Column(name="product_id",nullable = false)
    private Integer productId;
    @Column(name = "total_count",nullable = false)
    private Integer totalCount;
    @Column(name = "saled_count",nullable = false)
    private Integer saledCount;
    @Column(name = "create_time",nullable = false)
    private Date createTime;
    @Column(name = "update_time",nullable = false)
    private Date updateTime;
    @Version
    private Integer version;
}
