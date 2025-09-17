package com.nie.csd.controller;
import com.nie.csd.models.Products;
// import com.nie.csd.repositories.ProductRepository;
import com.nie.csd.services.ProductsService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class ProductController {
    @Autowired
    ProductsService service;

    @GetMapping("/demo")
    public String getProducts(){
        return "List of Products  from the products path";
    }

    @GetMapping("/products")
    public List<Products> getAllProducts(){
        return service.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Products getByProductId(@PathVariable("id") String id){
        return service.getByProductId(id);
    }

    @PostMapping("/products")
    public Products addProduct(@RequestBody Products products){
        return service.addProduct(products);
    }


    @PutMapping("/products/{id}")
    public Products updateProduct(@PathVariable("id") String id, @RequestBody Products products){
        return service.updateProduct(id,products);
        
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") String id){
        service.deleteProduct(id);
    }

}
