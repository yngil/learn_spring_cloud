package com.study.cloud.services;

import com.netflix.discovery.converters.Auto;
import com.study.cloud.ProductServiceApplication;
import com.study.cloud.products.common.ProductOutput;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@Slf4j
public class ProductControllerTest extends BaseTest{
    @MockBean
    private ProductService productService;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        when(productService.findById(anyInt())).then(new Answer<Products>() {
            @Override
            public Products answer(InvocationOnMock invocationOnMock) throws Throwable {
                Products p = new Products();
                p.setProductId(invocationOnMock.getArgument(0));
                return p;
            }
        });
    }

    @Test
    public void findAllProducts() {
    }

    @Test
    public void find() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(get("/products/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse();
        log.info("响应:{}",response.getContentAsString());
    }
}