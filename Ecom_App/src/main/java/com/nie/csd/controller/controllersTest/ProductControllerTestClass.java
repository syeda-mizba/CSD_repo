package com.nie.csd.controller.controllersTest;

import org.springframework.beans.factory.annotation.Autowired;
import com.nie.csd.controller.ProductController;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProductController.class)
public class ProductControllerTestClass {
    @Autowired
    ProductController controller;
    @Autowired
    MockMvc mockMvc;

    public void testSayHello()throws Exception{
        mockMvc.perform(get("/hello")).andExpect(status().isOk())
        .andExpect(content().string("HELLO"));
    }
    
}



