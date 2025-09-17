package com.nie.csd.controller.controllersTest;

import org.springframework.beans.factory.annotation.Autowired;
import com.nie.csd.controller.ProductController;
@SpringBootTest

public class ProductControllerTestClass {
    @Autowired
    ProductController controller;

    public void testSayHello(){
        String result= controller.sayHello();
        String expected="Hello from Product Controller";
        assert(result.equals(expected));
    }
    
}



