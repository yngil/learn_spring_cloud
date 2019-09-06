package com.study.cloud.services;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
@ContextConfiguration
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@FixMethodOrder(MethodSorters.DEFAULT)
public class ProductDaoTest extends BaseTest{

    @Autowired
    private ProductDao productDao;
    private TestContextManager testContextManager;

    @Parameterized.Parameters(name="{index}:{1}-{0}-{2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new BigDecimal(10),"小米Mix2s","M001"},{new BigDecimal(20),"小米Max","M001"}
        });
    }

    private Products products;

    public ProductDaoTest(BigDecimal price,String productName,String catalogCode) {
        products = new Products();
        products.setPrice(price);
        products.setProductName(productName);
        products.setCatalogCode(catalogCode);
    }

    @Before
    public void setUp() throws Exception {
        testContextManager = new TestContextManager(getClass());
        testContextManager.prepareTestInstance(this);
    }



    @Test
    public void insertProducts(){
        Products result = productDao.save(products);
        Assert.notNull(result,"保存商品失败");
    }

    @Test
    public void findAllProducts() {
        List<Products> list = productDao.findAllProducts();
        Assert.notEmpty(list,"产品列表不为空");
    }
}