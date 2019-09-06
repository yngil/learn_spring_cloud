package com.study.cloud.services;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id",unique = true)
    private Integer productId;
    @Column(name="price",nullable = false)
    private BigDecimal price;
    @Column(name="product_name",nullable = false)
    private String productName;
    @Column(name="catalog_code",nullable = false)
    private String catalogCode;
}
